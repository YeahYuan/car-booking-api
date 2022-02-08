package com.yuanjingjing.carbooking.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class CarModelBO {

    private int id;

    private String modelName;

    private int stock;

    private Map<LocalDate, Integer> dateMap;

    public CarModelBO(OrderDetailBO bo) {
        this.id = bo.getModelId();
        this.modelName = bo.getModelName();
        this.stock = bo.getStock();
        this.dateMap = new HashMap<>();
//        dateMap.put(bo.getDate(), bo.getOrdered());
    }
}
