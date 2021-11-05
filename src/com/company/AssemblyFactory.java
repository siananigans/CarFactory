package com.company;

import java.util.HashMap;

public class AssemblyFactory {
    HashMap<String, Integer> availableWorkers;

    public AssemblyFactory(){
        HashMap<String, Integer> availableWorkers = new HashMap<>();
        availableWorkers.put("Monday", 5);
        availableWorkers.put("Tuesday", 5);
        availableWorkers.put("Wednesday", 6);
        availableWorkers.put("Thursday", 6);
        availableWorkers.put("Friday", 5);
        availableWorkers.put("Saturday", 4);
        availableWorkers.put("Sunday", 3);
        this.availableWorkers = availableWorkers;
    }

    public int checkDaysToComplete(String day){
        return this.availableWorkers.get(day);
    }
}
