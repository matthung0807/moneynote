package idv.matt.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "idv.matt.controller, idv.matt.aop" })
@MapperScan(basePackages = "idv.matt.dao")
public class MoneynoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneynoteApplication.class, args);
    }

}
