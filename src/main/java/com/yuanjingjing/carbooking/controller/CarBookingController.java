package com.yuanjingjing.carbooking.controller;

import com.yuanjingjing.carbooking.service.CarModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "car booking api")
@RestController("/v1/car")
public class CarBookingController {

    @Resource
    CarModelService carModelService;

    @ApiOperation("query")
    @GetMapping("/models")
    public Object page(@RequestParam(required = false) Integer days) {
        return carModelService.list(days);
    }

    @ApiOperation("book car")
    @PostMapping("/book")
    public Object book(){

        return null;
    }
}
