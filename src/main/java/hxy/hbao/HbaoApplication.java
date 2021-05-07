package hxy.hbao;

import hxy.hbao.tool.DbOper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

@SpringBootApplication
@Slf4j
@EnableCaching
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HbaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(HbaoApplication.class, args);

 /*       ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-applicationContext.xml");
        Object user= context.getBean("userController");
        String[] str=context.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("..."+string);
        }
        System.out.println("----"+user);*/
    }

}
