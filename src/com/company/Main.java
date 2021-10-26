package com.company;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // set up car data


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

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(100 - 1) + 1;
        return randomNumber;
    }
}
