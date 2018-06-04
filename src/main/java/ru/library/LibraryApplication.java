package ru.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;





@SpringBootApplication
public class LibraryApplication  {


    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
