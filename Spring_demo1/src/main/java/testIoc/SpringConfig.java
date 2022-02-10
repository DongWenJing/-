package testIoc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//标记为配置文件
@ComponentScan("testIoc")//包扫描让注解生效
public class SpringConfig {
}
