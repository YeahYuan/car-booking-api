package com.yuanjingjing.carbooking.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.bo.OrderDetailBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;
import com.yuanjingjing.carbooking.entity.OrderDetailEntity;
import com.yuanjingjing.carbooking.entity.OrderEntity;
import com.yuanjingjing.carbooking.mapper.CarModelMapper;
import com.yuanjingjing.carbooking.mapper.OrderDetailMapper;
import com.yuanjingjing.carbooking.mapper.OrderMapper;
import com.yuanjingjing.carbooking.service.CarModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

@Service
public class CarModelServiceImpl extends ServiceImpl<CarModelMapper, CarModelEntity> implements CarModelService {

    @Resource
    OrderMapper orderMapper;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void booking(OderBookingBO bo) {
        int count = orderDetailMapper.countForUpdate(bo);
        if (count > 0) {
            throw new RuntimeException("Already booked!");
        }
        OrderEntity entity = bo.toEntity();
        orderMapper.insert(entity);
        List<OrderDetailEntity> detailEntityList = bo.toDetailEntity(entity.getId());
        for (OrderDetailEntity detail : detailEntityList) {
            orderDetailMapper.insert(detail);
        }
    }
}
