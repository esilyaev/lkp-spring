package eos.lkpspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LkpSpringApplication {

  public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "true");
    SpringApplication.run(LkpSpringApplication.class, args);
  }

}
