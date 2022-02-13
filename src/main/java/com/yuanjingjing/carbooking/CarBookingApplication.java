package com.yuanjingjing.carbooking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuanjingjing.carbooking.mapper")
public class CarBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarBookingApplication.class, args);
    }

}
