package com.yuanjingjing.carbooking.controller;

import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.config.Result;
import com.yuanjingjing.carbooking.service.CarModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;

@Api(tags = "car booking api")
@RestController("")
public class CarBookingController {

    @Resource
    CarModelService carModelService;

    @ApiOperation("query")
    @GetMapping("/models")
    public Collection<CarModelBO> page(@RequestParam(required = false) Integer days) {
        return carModelService.list(days);
    }

    @ApiOperation("book car")
    @PostMapping("/booking")
    public Result book(@RequestBody @Valid OderBookingBO bo) {
        if (bo.getEndDate().isBefore(bo.getStartDate())) {
            return Result.error(500, "End date cannot before start date!");
        }
        carModelService.booking(bo);
        return Result.ok();
    }
}
