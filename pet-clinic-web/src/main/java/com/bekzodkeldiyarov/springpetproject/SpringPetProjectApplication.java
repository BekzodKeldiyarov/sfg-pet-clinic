//package com.bekzodkeldiyarov.springpetproject;
package com.bekzodkeldiyarov.springpetproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringPetProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPetProjectApplication.class, args);
    }

}
