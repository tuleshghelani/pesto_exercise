package com.tulesh.springboot.enun;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public enum TaskStatus {
    ToDo("To Do"), InProgress("In Progress"), Done("Done");

    public String name;
    public String value;

    TaskStatus(String name) {
        this.name = name;
    }

    TaskStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getEnumByString(String code){
        for(TaskStatus e : TaskStatus.values()){
            if(e.value.equals(code)) return e.getName();
        }
        return null;
    }
    // Utility method to get the display value from the string status
    public static String getDisplayValueFromString(String status) {
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.name().equalsIgnoreCase(status)) {
                return taskStatus.getName();
            }
        }
        return null; // Or throw an exception if the status is not found
    }

    public static TaskStatus getTaskEnum(String value) {
        for (TaskStatus userCategory : TaskStatus.values()) {
            if (userCategory.getName().equals(value)) {
                return userCategory;
            }
        }
        return null;
    }

    public static List<String> getAllAnsTypeValue() {
        List<String> ansTypes = new ArrayList<>();
        for(TaskStatus e : TaskStatus.values()){
            ansTypes.add(e.value);
        }
        return ansTypes;
    }
}
