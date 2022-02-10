package testIoc;

import org.springframework.stereotype.Component;

@Component//把创建的对象交给Spring容器管理
public class Tiger implements Pet{

    private String name;
    private Integer age;
    @Override
    public void run() {
        System.out.println("小老虎跑贼快~");
    }

    @Override
    public void eat() {
        System.out.println("老虎爱吃肉~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void haha(){
        System.out.println("我是一直小老虎,名字叫做"+name+"今年"+age+"岁了");

    }
}
