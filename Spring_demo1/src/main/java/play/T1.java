package play;

public interface T1 {
  static final Integer A = 2132;
    void cat();
    default void eat(){
        System.out.println("默认方法");
    }
    static void eat1(){
        System.out.println("静态方法");
    }

}
