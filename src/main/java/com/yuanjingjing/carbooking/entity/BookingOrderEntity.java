package com.yuanjingjing.carbooking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookingOrderEntity {

    @TableId(type = IdType.AUTO)
    private int id;

    private int modelId;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate endDate;
}
