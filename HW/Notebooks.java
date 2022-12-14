package HW;

import java.util.*;

public class Notebooks {
    String name;

    int operMemory;
    int hddMemory;
    String color;
    String system;

    Double sizeMonitor;

    public String getName() {
        Map <Integer, String> listNote = new HashMap<>();
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public int getOperMemory() {
        return operMemory;
    }
    public void setOperMemory(int operMemory) {
        this.operMemory = operMemory;
    }
    

    public int getHddMemory() {
        return hddMemory;
    }
    public void setHddMemory(int hddMemory) {
        this.hddMemory = hddMemory;
    }


    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }


    public String getSystem() {
        return system;
    }
    public void setSystem(String system) {
        this.system = system;
    }


    public Double getSizeMonitor() {
        return sizeMonitor;
    }
    public void setSizeMonitor(Double sizeMonitor) {
        this.sizeMonitor = sizeMonitor;
    }
}