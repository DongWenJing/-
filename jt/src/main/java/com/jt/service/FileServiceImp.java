package com.jt.service;

import com.jt.vo.ImageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 14:23
 */
@Service
public class FileServiceImp implements FileService{
    /**
     * 业务说明:
     *  1.校验图片的类型是否为jpg/png/gif
     *  2.校验文件是否为恶意程序  防止木马病毒
     *  3.按照分目录的结构存储
     *  4.需要考虑重名问题,应该让文件名称不重复
     * @param file
     * @return
     */
    private String localDir = "E:/Code/JT_SOFT/images";
    @Override
    public ImageVO upload(MultipartFile file)  {

        //1.校验图片的类型
        //1.1获取图片的名称  设:abc.jpg ABC.JPG
        String fileName = file.getOriginalFilename();
        //1.2 将字母转化为小写
       fileName = fileName.toLowerCase();
        //1.3正则表达式写法
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")){
            return null;
        }
        //2.防止木马病毒 图片的宽度和高度
        try {
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
            if (height == 0 || width==0) {
                //说明不是正经的图片
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            //如果出现了异常信息则返回空
            return  null;
        }
        //3.分目录存储 提交的时间|名称hash 进行存储
        String datePath = new SimpleDateFormat("/YYYY/MM/dd/")
                .format(new Date());
        //3.1创建图片目录
        String  dirPath = localDir + datePath;
        //3.2创建目录
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //4.要求文件名称不重名 uuid.type
        String uuid = UUID.randomUUID().toString();
        int index = fileName.lastIndexOf(".");
        //.jpg
        String type = fileName.substring(index);
        fileName = uuid + type;

        //5.实现文件上传
        String realFilePath = dirPath  + fileName;
        try {
            file.transferTo(new File(realFilePath));
            //6.返回ImageVO对象
            String virtualPath = datePath+fileName;
            String urlPath = "https://img14.360buyimg.com/n0/jfs/t1/98058/27/22325/188272/620ba777E57f96e29/23e4957b779d0b24.jpg"; //网络图片
            ImageVO imageVO = new ImageVO(virtualPath,urlPath,fileName);
            return imageVO;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 删除文件业务
     * 1.指定删除文件的路径
     * 2.利用File对象实现删除
     * @param virtualPath
     */
    @Override
    public void deleteFile(String virtualPath) {
        //拼的磁盘地址
        String path = localDir + virtualPath;

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 实现文件上传操作:
     *  1.获取文件上传名称
     *  2.准备文件上传的目录
     *  3.实现文件上传操作
     *
     *  注意事项:
     *      1.图片选择稳定图片
     *      2.大小不要超过1MB
     * @param file
     * @return
     */
/*    @Override
    @Transactional
    public ImageVO upload(MultipartFile file) {
        //1.获取文件名称
        String fileName = file.getOriginalFilename();
        //2.指定磁盘路径信息
        String filePath = "E:/Code/JT_SOFT/images";

        //3.检验目录是否存在
        File dirFile = new File(filePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();//创建多级目录
        }
        //4.准备文件的全路径
        String path = filePath +"/" + fileName;
        //5.将路径包装为File对象
        File imageFile = new File(path);
        //6.实现文件的上传
        try {
            file.transferTo(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
