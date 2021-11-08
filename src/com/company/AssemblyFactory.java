package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.time.LocalDate;
import java.time.DayOfWeek;

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

    public int estimateAssemblyTime(int totalAssemblyDays) {
        String dayOfWeek = getDayString();
        int workerCount = availableWorkers.get(dayOfWeek);
        if (workerCount >= totalAssemblyDays) {
            return 1;
        }
        // Add logic to get each day + workers
        else {
            return totalAssemblyDays / workerCount;
        }
    }

    public static String getDayString() {
        Locale locale = new Locale("EN", "IE");
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, locale);
    }
}
