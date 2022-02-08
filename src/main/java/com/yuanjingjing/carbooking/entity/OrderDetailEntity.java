package com.yuanjingjing.carbooking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderDetailEntity {
    @TableId(type = IdType.AUTO)
    private int id;

    private int modelId;

    private int orderId;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate date;


}
