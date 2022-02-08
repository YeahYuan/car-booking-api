package com.yuanjingjing.carbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanjingjing.carbooking.bo.OrderDetailBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;
import com.yuanjingjing.carbooking.entity.OrderDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetailEntity> {

    @Select("SELECT m.id AS model_id, m.name, m.stock, d.* FROM car_model m LEFT JOIN\n" +
            "(SELECT model_id AS id, date, count(id) AS ordered FROM order_detail WHERE date >= #{startDate} AND date <= #{endDate} GROUP BY model_id, date) d\n" +
            "ON m.id = d.id" )
    List<OrderDetailBO> select(LocalDate startDate, LocalDate endDate);
}
