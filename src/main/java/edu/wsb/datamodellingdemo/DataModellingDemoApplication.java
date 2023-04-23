package edu.wsb.datamodellingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled=true)
public class DataModellingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataModellingDemoApplication.class, args);
    }

}
