package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class CarOrder {
    int carCount;
    String carMake;
    String carModel;
    int daysToComplete;
    int orderNumber;

    public CarOrder(int carCount, String carMake, String carModel, int orderDeadlineDays, int orderNumber){
        this.carMake = carMake;
        this.carModel = carModel;
        this.carCount = carCount;
        this.daysToComplete = orderDeadlineDays;
        this.orderNumber = orderNumber;
    }
    public Car getOrderedCar(HashMap<String, ArrayList<Car>> cars) {
        ArrayList<Car> modelCars = cars.get(carMake);
        System.out.println(modelCars);
        for (Car car : modelCars) {
            if (Objects.equals(car.make, carMake)) {
                return car;
            }
        }
        return null;
    }
}
