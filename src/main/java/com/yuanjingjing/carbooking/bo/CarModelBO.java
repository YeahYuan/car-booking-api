package com.yuanjingjing.carbooking.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class CarModelBO {

    private Integer id;

    private String modelName;

    private Integer stock;

    private Map<LocalDate, Integer> dateMap;

    public CarModelBO(OrderDetailBO bo) {
        this.id = bo.getModelId();
        this.modelName = bo.getModelName();
        this.stock = bo.getStock();
        this.dateMap = new HashMap<>();
    }
}
