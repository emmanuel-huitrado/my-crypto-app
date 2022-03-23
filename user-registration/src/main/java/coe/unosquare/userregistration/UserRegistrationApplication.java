package coe.unosquare.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UserRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRegistrationApplication.class,args);
    }
}