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

    public CarOrder(int count, String make, String model, int deadlineDays){
        carMake = make;
        carModel = model;
        carCount = count;

        orderDeadlineDays = deadlineDays;
    }
}
