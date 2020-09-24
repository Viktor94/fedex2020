package com.example.fedex_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class FedexBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(FedexBackendApplication.class, args);
  }
}
