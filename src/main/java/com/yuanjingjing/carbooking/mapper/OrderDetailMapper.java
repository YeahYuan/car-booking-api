package com.yuanjingjing.carbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.bo.OrderDetailBO;
import com.yuanjingjing.carbooking.entity.OrderDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetailEntity> {

    @Select("SELECT m.id AS modelId, m.name AS modelName, m.stock, d.* FROM car_model m LEFT JOIN " +
            "(SELECT model_id AS id, date, count(id) AS ordered FROM order_detail WHERE date >= #{startDate} AND date <= #{endDate} GROUP BY model_id, date) d " +
            "ON m.id = d.id")
    List<OrderDetailBO> select(LocalDate startDate, LocalDate endDate);

    /*
    查询在这个日期范围内是否有某一天的库存不足
     */
    @Select("SELECT " +
            " count( 1 )  " +
            "FROM " +
            " ( " +
            " SELECT " +
            "  order_detail.model_id, " +
            "  order_detail.date, " +
            "  count( order_detail.id ) AS booked, " +
            "  car_model.stock  " +
            " FROM " +
            "  order_detail " +
            "  LEFT JOIN car_model ON car_model.id = order_detail.model_id  " +
            " WHERE " +
            "  order_detail.model_id = #{modelId}  " +
            "  AND order_detail.date BETWEEN #{startDate}  " +
            "  AND #{endDate}  " +
            " GROUP BY " +
            "  order_detail.model_id, " +
            "  order_detail.date  " +
            " ) t  " +
            "WHERE " +
            " booked >= stock")
    int countForUpdate(OderBookingBO bo);
}
