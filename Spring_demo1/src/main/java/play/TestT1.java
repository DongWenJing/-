package play;

import play.T1;

public class TestT1 {
    public static void main(String[] args) {
        function( ()-> {});
    }
    public static void function(T1 t1){
        t1.cat();
    }
}
