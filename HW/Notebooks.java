import java.util.*;

public class Notebooks {
    
    private String name;
    private int ramVolume;
    private int hddVolume;
    private String system;
    private Double sizeMonitor;
    private String color;
    
    public Notebooks (String name, int ramVolume, int hddVolume, String system, Double sizeMonitor, String color) {
        this.name = name;
        this.ramVolume = ramVolume;
        this.hddVolume = hddVolume;
        this.color = color;
        this.system = system;
        this.sizeMonitor = sizeMonitor;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public int getRamVolume() {
        return ramVolume;
    }
    public void setRamVolume(int ramVolume) {
        this.ramVolume = ramVolume;
    }
    

    public int getHddVolume() {
        return hddVolume;
    }
    public void setHddVolume(int hddVolume) {
        this.hddVolume = hddVolume;
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
    
        
    @Override
    public String toString () {
        return  "Ноутбук " + name +
                "\nОперативная память, Гб: " + ramVolume +
                "\nЖесткий диск, Гб: " + hddVolume +
                "\nОС: " + system +
                "\nДиагональ монитора, дюйм: " + sizeMonitor +
                "\nЦвет: " + color + "\n\n";
    }
    
    @Override
    public boolean equals (Object value) {
        if (this == value) {
            return true;
        }
        if (!(value instanceof Notebooks)) {
            return false;
        }
        Notebooks note = (Notebooks) value;
        if (this.getName().equals(note.getName())
        && this.getRamVolume()==note.getRamVolume()
        && this.getHddVolume()==note.getHddVolume()
        && this.getSizeMonitor().equals(note.getSizeMonitor())) {
            return true;
        }
        return false;
    }
}
