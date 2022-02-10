package functionInterface;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {
        f1(()->{
            int[] array ={
                    1,3,2,8,5,7,6
            };
            //计算出数组中的最大值
            Arrays.sort(array);
            return array[array.length-1];
        });
        f2();
        new Thread(()->{
            System.out.println("新线程:"+Thread.currentThread().getName());
        }).start();
    }

    private static void f1(Supplier<Integer> supplier){

        Integer max = supplier.get();//调用Supplier接口提供的抽象方法get--->无参有返回值
        System.out.println("最大值:" +max);
    }
    public static void f2() {
        //新建一个ArrayList集合用来储存Student数据
        List<Student> list = new ArrayList<>();
        //向集合中添加数据
        list.add(new Student("小花", 19, "女"));
        list.add(new Student("小呆", 18, "男"));
        list.add(new Student("小光", 23, "女"));
        list.add(new Student("小胖", 21, "男"));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Student student : list) {
            System.out.println(student);
        }
    }


}