package play;
//内部类物料类
public class Inner1 {

    public static void main(String[] args) {

        //方式一:通过创建外部类对象,创建内部类对象
        Out.In in = new Out().new In();
        in.play();
        //方式二:通过外部的方法中的对象调用内部类方法\
        new Out().getIn();

    }
  static   class Out{//外部类
        public void  getIn(){
            In in = new In();
            in.play();
        }
         class In{//内部类
            private void play(){
                System.out.println("玩个锤子");
            }
        }
    }
}
