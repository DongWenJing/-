package com.jt.service;

import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ItemCatServiceImp implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * 业务:Map<parentId,List<ItemCat>>
     * 思路:
     *     判断Map中是否有key
     *     true: 获取list集合,将自己追加到集合中
     *     false : new List集合,将自己作为第一个元素保存,之后存储Map
     */
    public Map<Integer, List<ItemCat>> getMap(){
        Map<Integer, List<ItemCat>>  map = new HashMap<>();
        //1.查询所有的数据库信息
      List<ItemCat> list =  itemCatMapper.findItemCatList();
      //2.遍历数据封装Map
        for (ItemCat itemCat : list) {
            Integer key = itemCat.getParentId();
            if (map.containsKey(key)) {
                map.get(key).add(itemCat);
            }else{ // key不存在,则创建list对象,添加第一个数据
             List<ItemCat> tempList  =  new ArrayList<>();
             tempList.add(itemCat);
             map.put(key, tempList);
            }
        }
        return map;
    }

    @Override
    public List<ItemCat> findItemCatList(Integer level) {
        long startTime = System.currentTimeMillis();
        Map<Integer, List<ItemCat>> map = getMap();
        //level=1,只查询一级数据
        if (level == 1) {
          return map.get(0);
        }
        //level = 2,查询一级和二级的数据
        if (level == 2) {
            return getTwoList(map);
        }
        //level = 3,查询一级和二级还有三级的数据
       List<ItemCat> threeList = getThreeList(map);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"毫秒");
            return threeList;
    }

    @Override
    @Transactional
    public void updateStatus(ItemCat itemCat) {
        itemCat.setUpdated(new Date());
        itemCatMapper.updateStatus(itemCat);
    }

    @Override
    @Transactional
    public void saveItemCat(ItemCat itemCat) {
        Date date = new Date();
        itemCat.setStatus(true).setCreated(date).setUpdated(date);

        itemCatMapper.saveItemCat(itemCat);
    }

    @Override
    @Transactional
    public void updateItemCat(ItemCat itemCat) {
        Date date = new Date();
        itemCat.setUpdated(date);
        itemCat.setStatus(true);
        itemCatMapper.updateItemCat(itemCat);
    }

    //删除商品分类信息
    @Override
    @Transactional
    public void deleteItemCat(ItemCat itemCat) {
        //判断level到底是几级菜单
        if(itemCat.getLevel()==3){
            itemCatMapper.deleteItemCatById(itemCat.getId());
        }
        if (itemCat.getLevel()==2){
            //应该删除三级以及二级菜单
            itemCatMapper.deleteItemCatById2(itemCat.getId());
        }
        if (itemCat.getLevel() == 1) {
            //删除一二三级菜单
            itemCatMapper.deleteItemCatById3(itemCat.getId());
        }


    }

    /**
     * 思路:
     *      1.获取三级商品分类信息
     *      2.先应该获取2级商品信息
     *
     */
    private List<ItemCat> getThreeList(Map<Integer, List<ItemCat>> map) {
        //1.先查询一级和二级的数据
     List<ItemCat> oneList = getTwoList(map);
     //2.遍历一级集合,获取二级数据
        for (ItemCat oneItemCat : oneList) {
            //2.1获取二级的数据信息可能为null
            List<ItemCat> twoList = oneItemCat.getChildren();
            if (twoList == null || twoList.size()==0)
                continue;
            for (ItemCat twoItemCat : twoList) {
                Integer twoId = twoItemCat.getId();
                //2.2获取三级集合信息
                List<ItemCat> threeList = map.get(twoId);
                //2.3将三级数据封装到二级对象当中
                twoItemCat.setChildren(threeList);
            }
        }
        return oneList;
    }

    //二级菜单业务
    private List<ItemCat> getTwoList(Map<Integer, List<ItemCat>> map) {
        //1.查询一级数据
        List<ItemCat> oneList = map.get(0);
        for (ItemCat oneItemCat : oneList) {
            //获取一级id
            Integer id = oneItemCat.getId();
            //根据一级id查询二级数据
            List<ItemCat> twoList = map.get(id);
            oneItemCat.setChildren(twoList);

        }
        return oneList;
    }

//    @Override
//    @Transactional
//    public List<ItemCat> findItemCatList(Integer level) {
//        long startTime = System.currentTimeMillis();
//        //1.查询一级菜单
//        Integer level1=1; //通过level查询
//        Integer parentId = 0;  //通过parentId查询
//      List<ItemCat> oneList =  itemCatMapper.findItemCatByParentId(parentId);
//      List<ItemCat> oneList2 =  itemCatMapper.findItemCatList(level1);
//
//      //2.查询二级分类
//        for (ItemCat oneItemCat : oneList) {
//            //2.1根据一级的id查询二级的数据
//            Integer oneId = oneItemCat.getId();
//         List<ItemCat> twoList =  itemCatMapper.findItemCatByParentId(oneId);
//         oneItemCat.setChildren(twoList);
//            List<ItemCat> children = oneItemCat.getChildren();
//            for (ItemCat twoItemCat : children) {
//                //根据二级id查询三级的数据
//                Integer twoId = twoItemCat.getId();
//             List<ItemCat> threeList =  itemCatMapper.findItemCatByParentId(twoId);
//             twoItemCat.setChildren(threeList);
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("耗时:"+(endTime-startTime)+"毫秒");
//      return oneList ;
//    }
}
