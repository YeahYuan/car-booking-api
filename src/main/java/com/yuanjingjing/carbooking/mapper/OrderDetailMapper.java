package com.yuanjingjing.carbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.bo.OrderDetailBO;
import com.yuanjingjing.carbooking.entity.CarModelEntity;
import com.yuanjingjing.carbooking.entity.OrderDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetailEntity> {

    @Select("SELECT m.id AS modelId, m.name AS modelName, m.stock, d.* FROM car_model m LEFT JOIN\n" +
            "(SELECT model_id AS id, date, count(id) AS ordered FROM order_detail WHERE date >= #{startDate} AND date <= #{endDate} GROUP BY model_id, date) d\n" +
            "ON m.id = d.id" )
    List<OrderDetailBO> select(LocalDate startDate, LocalDate endDate);

    /*
    查询在这个日期范围内是否有某一天的库存不足
     */
    @Select("SELECT\n" +
            "\tcount( 1 ) \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\torder_detail.model_id,\n" +
            "\t\torder_detail.date,\n" +
            "\t\tcount( order_detail.id ) AS booked,\n" +
            "\t\tcar_model.stock \n" +
            "\tFROM\n" +
            "\t\torder_detail\n" +
            "\t\tLEFT JOIN car_model ON car_model.id = order_detail.model_id \n" +
            "\tWHERE\n" +
            "\t\torder_detail.model_id = #{modelId} \n" +
            "\t\tAND order_detail.date BETWEEN #{startDate} \n" +
            "\t\tAND #{endDate} \n" +
            "\tGROUP BY\n" +
            "\t\torder_detail.model_id,\n" +
            "\t\torder_detail.date \n" +
            "\t) t \n" +
            "WHERE\n" +
            "\tbooked >= stock")
    int countForUpdate(OderBookingBO bo);
}
