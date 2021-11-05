package com.company;
import java.util.Date;
import java.util.HashMap;

import java.text.SimpleDateFormat;
import java.util.Date;

class CarOrder {
    int carCount;
    String carMake;
    String carModel;
    int orderDeadlineDays;
    int orderNumber;

    public CarOrder(int carCount, String carMake, String carModel, int orderDeadlineDays, int orderNumber){
        this.carMake = carMake;
        this.carModel = carModel;
        this.carCount = carCount;

        this.orderDeadlineDays = orderDeadlineDays;
        this.orderNumber = orderNumber;
    }
}
