package com.yuanjingjing.carbooking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;

import java.util.Collection;

public interface CarModelService extends IService<CarModelEntity> {

    Collection<CarModelBO> list(Integer days);

    void booking(OderBookingBO bo);

}
