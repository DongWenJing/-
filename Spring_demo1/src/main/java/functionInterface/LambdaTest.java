package functionInterface;

// (参数列表)  -> {代码体 }
//// ():里面放参数
//         ->: 运算符(读作goes to) 分割参数列表和方法体
//         { }: 方法体
public class LambdaTest {
    public static void main(String[] args) {
//        f1(new T1() {
//            @Override
//            public void eat() {
//                System.out.println("1111");
//            }
//        });

        f1(()->System.out.println("1111")
        );
    }
    public static   void f1(T1 t1){
        t1.eat();
    }
}
