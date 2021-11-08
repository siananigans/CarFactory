package com.company;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Set up car data
        HashMap<String, ArrayList<Car>> carStock = populateCarStock();
        System.out.println(carStock);

        // Set up Assembly Factory
        AssemblyFactory assemblyFactory = new AssemblyFactory();

        int order = 1;
        while(true) {
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

            // Create order
            CarOrder carOrder = new CarOrder(count, make, model, deadlineDays, order);
            order++;

            // Estimate completion time
            Car orderedCar = carOrder.getOrderedCar(carStock);
            int assemblyDays = assemblyFactory.estimateAssemblyTime(orderedCar.daysToAssemble * carOrder.carCount);
            // Add 1 day to complete order
            int daysToOrderComplete = assemblyDays + 1;

            if (daysToOrderComplete < carOrder.orderDeadlineDays) {
                System.out.println("Order Number: ");
                System.out.println(carOrder.orderNumber);
                System.out.println("Days until Order completion: ");
                System.out.println(daysToOrderComplete);
            }
            else {
                System.out.println("Order cannot be processed in the desired time slot.");
                System.out.println("Estimated time to complete: ");
                System.out.println(daysToOrderComplete);
            }
        }
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
        HashMap<String, ArrayList<Car>> carStock = new HashMap<>();
        for (int i = 0; i < carModels.length; i++) {
            String make = carMakes[i];
            String[] models = carModels[i];
            ArrayList<Car> makeCars = new ArrayList<>(); // Create an ArrayList object
            for (String s : models) {
                int countInStock = getRandomNumber(0, 100000);
                int daysToAssemble = getRandomNumber(0, 20);
                Car tmpCar = new Car(countInStock, i, make, s, daysToAssemble);
                makeCars.add(tmpCar);
            }
            carStock.put(make, makeCars);
        }
        return carStock;
    }
}
