package com.yuanjingjing.carbooking.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderDetailBO {

    private int modelId;

    private String modelName;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate date;

    private int stock;

    private int ordered;

}
