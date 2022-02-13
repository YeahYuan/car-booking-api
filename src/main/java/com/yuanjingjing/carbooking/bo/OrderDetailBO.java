package com.yuanjingjing.carbooking.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderDetailBO {

    private Integer modelId;

    private String modelName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Integer stock;

    private Integer ordered;

}
