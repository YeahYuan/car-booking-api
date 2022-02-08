package com.yuanjingjing.carbooking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;

import java.util.Collection;
import java.util.List;

public interface CarModelService extends IService<CarModelEntity> {

    Collection<CarModelBO> list(Integer days);


}
