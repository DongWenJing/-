package play;

public class Test1 {
    public static void main(String[] args) {
        //方式一,把实现类给他,麻烦还得多写个实现类
       // function(new Student());
        //方式二,把接口作为参数
        function(new Inter1() {
            @Override
            public void eat() {
                System.out.println("接口参数的(๑′ᴗ‵๑)Ｉ Lᵒᵛᵉᵧₒᵤ❤");
            }

            @Override
            public void play() {
                System.out.println("玩不死你");
            }
        });

    }
    public static void function(Inter1 i){
        i.play();
        i.eat();
    }
}
