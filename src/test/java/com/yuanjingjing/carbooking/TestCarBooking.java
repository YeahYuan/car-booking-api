package com.yuanjingjing.carbooking;

import com.yuanjingjing.carbooking.bo.CarModelBO;
import com.yuanjingjing.carbooking.bo.OderBookingBO;
import com.yuanjingjing.carbooking.service.CarModelService;
import com.yuanjingjing.carbooking.service.impl.CarModelServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarBookingApplication.class)
public class TestCarBooking extends TestCase {

    @Autowired
    CarModelService carModelService;

    @Test
    public void testQuery() {
        Collection<CarModelBO> list = carModelService.list(7);
        assertEquals(list.size(), 2);
    }

    @Test
    public void testBook() {
        OderBookingBO bo = new OderBookingBO();
        bo.setModelId(2);
        bo.setStartDate(LocalDate.now().plusDays(2));
        bo.setEndDate(LocalDate.now().plusDays(2));
        carModelService.booking(bo);

    }
}
