package fishapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FishApp {

    public static void main(String[] args) {
        SpringApplication.run(FishApp.class, args);
    }
}
