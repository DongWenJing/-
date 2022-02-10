package play;

public class Student implements Inter1{
    private Integer age;
    private String name;
    @Override
    public void eat(){
       System.out.println("吃成个猪~");
   }
   @Override
    public void play(){
        System.out.println("玩鸟~");
    }
}
