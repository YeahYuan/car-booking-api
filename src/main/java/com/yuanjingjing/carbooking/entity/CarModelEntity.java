package com.yuanjingjing.carbooking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarModelEntity {

    @TableId(type = IdType.AUTO)
    private int id;

    private String modelName;

    private String modelDesc;

    private int stock;
}
