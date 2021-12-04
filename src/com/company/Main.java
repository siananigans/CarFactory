package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Set up car data
        HashMap<String, ArrayList<Car>> carStock = populateCarStock();
        System.out.println(carStock);

        // Set up Assembly Factory
        AssemblyFactory assemblyFactory = new AssemblyFactory();
        HashMap<Integer, CarOrder> carOrders = new HashMap<>();
        int orderNumber = 1;
        while(true) {
            // Read in car data
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to our interactive Car Factory");
            System.out.println("Options: \n 1. Create new order \n 2. Get existing order");
            String option1 = scanner.nextLine();
            if (Objects.equals(option1, "2")){
                System.out.println("Enter Order Number:");
                Integer queryOrderNumber = scanner.nextInt();
                CarOrder carOrder = carOrders.get(queryOrderNumber);
                if (carOrder != null) {
                    System.out.println("Car Order Number " + orderNumber);
                    System.out.println("Make: " + carOrder.carMake);
                    System.out.println("Model: " + carOrder.carModel);
                    System.out.println("Number of Cars: " + carOrder.carCount);
                    System.out.println("Days Remaining: " + carOrder.daysToComplete);
                }
                else {
                    System.out.println("Car order does not exist.");
                }
            }
            else if (Objects.equals(option1, "1")){

                System.out.println("Enter Make:");
                String make = scanner.nextLine();
                System.out.println("Enter Model:");
                String model = scanner.nextLine();
                System.out.println("Enter Count:");
                int count = scanner.nextInt();
                System.out.println("Enter due date:");
                int deadlineDays = scanner.nextInt();

                // Create order
                CarOrder carOrder = new CarOrder(count, make, model, deadlineDays, orderNumber);
                orderNumber++;

                // Estimate completion time
                Car orderedCar = carOrder.getOrderedCar(carStock);
                int assemblyDays = assemblyFactory.estimateAssemblyTime(orderedCar.daysToAssemble * carOrder.carCount);

                // Add 1 day to complete order
                int daysToOrderComplete = assemblyDays + 1;

                if (daysToOrderComplete < carOrder.daysToComplete) {
                    carOrders.put(carOrder.orderNumber, carOrder);
                    System.out.println("Order Number: ");
                    System.out.println(carOrder.orderNumber);
                    System.out.println("Days until Order completion: ");
                    System.out.println(daysToOrderComplete);
                } else {
                    System.out.println("Order cannot be processed in the desired time slot.");
                    System.out.println("Estimated time to complete: ");
                    System.out.println(daysToOrderComplete);
                }
            }
            else {
                System.out.println("Invalid option, please choose a valid number input.");
            }
            System.out.println();
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
                int daysToAssemble = getRandomNumber(0, 10);
                Car tmpCar = new Car(countInStock, i, make, s, daysToAssemble);
                makeCars.add(tmpCar);
            }
            carStock.put(make, makeCars);
        }
        return carStock;
    }
}
