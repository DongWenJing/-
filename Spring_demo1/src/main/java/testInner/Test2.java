package testInner;

public class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        getT1(()->{

        });
    }


    public static void getT1(T1 t1){
        t1.goHome();
    }
}
