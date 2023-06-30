package com.wnet.dscommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DscommerceApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(DscommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            //passwordEncoder.encode("123456");
            System.out.println("ENCODE = " + passwordEncoder.encode("123456"));
            boolean result = passwordEncoder.matches("123456", "$2a$10$tTVgwZYQx6RHjZ1PflTff.G/aPcOBfK86Z0FsYNtDFFZBM/GQ.EfS");
            System.out.println("RESULTADO = " + result);
        };
    }

}
