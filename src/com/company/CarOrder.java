package com.company;
import java.util.ArrayList;
import java.util.HashMap;

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
    public Car getOrderedCar(HashMap<String, ArrayList<Car>> cars) {
        ArrayList<Car> modelCars = cars.get(carMake);
        for (Car car : modelCars) {
            if (car.make == carMake) {
                return car;
            }
        }
        return null;
    }
}
