package main.java.com.yourcompany.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String name;
    private List<Integer> availableSlots; // Available time slots (e.g., 1 for 9-11 AM, 2 for 11-1 PM, etc.)

    public Professor(String name) {
        this.name = name;
        this.availableSlots = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<Integer> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public void addAvailableSlot(int slot) {
        this.availableSlots.add(slot);
    }
}
