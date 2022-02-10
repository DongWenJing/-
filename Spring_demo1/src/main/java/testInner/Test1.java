package testInner;

public class Test1 {
    public static void main(String[] args) {
        //怎么使用内部内的资源呢

        //当内部内被私有化,无法直接创对象该咋搞?
        new Outer().getInner();

    }
}
class Outer{//外部类
    //定义俩外部类的成员变量
    private Integer age;
    String name;
    public void haha(){//外部类的方法
        //外部类能不能使用内部类的属性和方法呢?
    }
    public Inner getInner(){
        Inner inner = new Inner();
        inner.heihei();
        System.out.println(inner.toyours);
        return inner;

    }
 private class Inner {//内部类
        //来俩内部类的成员变量
        Integer year = 2020;
        private String toyours = "新年快乐";
        //内部类的方法
        public void heihei(){
            //内部类能不能使用外部的资源怎么使用?
            //外部类的资源要是被private修饰呢?
            System.out.println("嘿嘿嘿");

        }
    }
}

