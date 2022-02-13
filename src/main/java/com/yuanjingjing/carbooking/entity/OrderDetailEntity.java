package com.yuanjingjing.carbooking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@TableName(value = "order_detail")
public class OrderDetailEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer modelId;

    private Integer orderId;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate date;


}
