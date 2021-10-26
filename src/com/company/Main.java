package com.company;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // set up car data

        HashMap<String, ArrayList<Car>> carStock = populateCarStock();
        System.out.println(carStock);

        // Read in car data
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Make:");
        String make = scanner.nextLine();
        System.out.println("Enter Model:");
        String model = scanner.nextLine();
        System.out.println("Enter Count:");
        int count = scanner.nextInt();
        System.out.println("Enter due date:");
        int deadlineDays = scanner.nextInt();
        CarOrder newCar = new CarOrder(count, make, model, deadlineDays);
        System.out.println(newCar.carCount);
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(100 - 1) + 1;
        return randomNumber;
    }

    public static HashMap<String, ArrayList<Car>> populateCarStock() {
        String[] carMakes = {"Volvo", "BMW", "Ford", "Mazda"};
        String[] volvoModels = {"S90", "V50", "G60 Drive"};
        String[] bmwModels = {"Series 1", "Series 2 Coupe"};
        String[] fordModels = {"Fiesta", "Focus"};
        String[] mazdaModels = {"CX-50", "CX-30", "MX-90"};
        String[][] carModels = new String[][] { volvoModels, bmwModels, fordModels, mazdaModels};
        HashMap<String, ArrayList<Car>> carStock = new HashMap<String, ArrayList<Car>>();
        for (int i = 0; i < carModels.length; i++) {
            String make = carMakes[i];
            String[] models = carModels[i];
            ArrayList<Car> makeCars = new ArrayList<Car>(); // Create an ArrayList object
            for (int j = 0; j < models.length; j++) {
                int countInStock = getRandomNumber(0, 100000);
                int daysToAssemble = getRandomNumber(0, 20);
                long id = i;
                String model = models[j];
                Car tmpCar = new Car(countInStock, id, make, model, daysToAssemble);
                makeCars.add(tmpCar);
            }
            carStock.put(make, makeCars);
        }
        return carStock;
    }
}
