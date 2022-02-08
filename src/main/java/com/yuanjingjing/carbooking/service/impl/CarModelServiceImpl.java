package com.yuanjingjing.carbooking.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.bo.OrderDetailBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;
import com.yuanjingjing.carbooking.mapper.CarModelMapper;
import com.yuanjingjing.carbooking.mapper.OrderDetailMapper;
import com.yuanjingjing.carbooking.service.CarModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

@Service
public class CarModelServiceImpl extends ServiceImpl<CarModelMapper, CarModelEntity> implements CarModelService {

    @Resource
    OrderDetailMapper orderDetailMapper;

    @Override
    public Collection<CarModelBO> list(Integer days) {
        List<OrderDetailBO> list = orderDetailMapper.select(LocalDate.now(), LocalDate.now().plusDays(null == days ? 7 : days));
        Map<Integer, CarModelBO> map = new HashMap<>();
        for (OrderDetailBO bo : list) {
            map.putIfAbsent(bo.getModelId(), new CarModelBO(bo));
            CarModelBO model = map.get(bo.getModelId());
            if (null != bo.getDate()) {
                Objects.requireNonNull(model).getDateMap().put(bo.getDate(), bo.getOrdered());
            }
        }
        return map.values();
    }
}
