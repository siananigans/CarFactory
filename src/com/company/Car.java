package com.company;

public class Car {
    int countInStock;
    long id;
    String make;
    String model;
    int daysToAssemble;

    public Car(int countInStock, long id, String make, String model, int daysToAssemble) {
        this.countInStock = countInStock;
        this.id = id;
        this.make = make;
        this.model = model;
        this.daysToAssemble = daysToAssemble;
    }
}
