package com.yuanjingjing.carbooking.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuanjingjing.carbooking.entity.OrderEntity;
import com.yuanjingjing.carbooking.entity.OrderDetailEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OderBookingBO {

    @NotNull(message = "Model id cannot be empty!")
    private Integer modelId;

    @NotNull(message = "Booking start date cannot be empty!")
    @Future(message = "Booking start date cannot before today!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Booking end date cannot be empty!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public OrderEntity toEntity() {
        OrderEntity entity = new OrderEntity();
        entity.setModelId(modelId);
        entity.setStartDate(startDate);
        entity.setEndDate(endDate);
        return entity;
    }

    public List<OrderDetailEntity> toDetailEntity(Integer orderId) {
        ArrayList<OrderDetailEntity> list = new ArrayList<>();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            OrderDetailEntity entity = new OrderDetailEntity();
            entity.setModelId(modelId);
            entity.setOrderId(orderId);
            entity.setDate(date);
            list.add(entity);
        }
        return list;
    }
}
