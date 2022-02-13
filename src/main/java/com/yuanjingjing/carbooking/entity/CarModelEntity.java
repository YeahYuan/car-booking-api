package com.yuanjingjing.carbooking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "car_model")
public class CarModelEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String modelName;

    private String modelDesc;

    private Integer stock;
}
