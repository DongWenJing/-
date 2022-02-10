package testIoc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTiger {
    public static void main(String[] args) {
    ApplicationContext context =   new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = context.getBean(Tiger.class);
        tiger.haha();
    }
}
