package data;

public class Teacher extends User {

    private String scince;

    public Teacher(String fio, int birthYear, long passport, String scince, int id) {
        super(fio, birthYear, passport, id);
        this.scince = scince;
    }

    public String getScince() {
        return scince;
    }

    public void setScince(String scince) {
        this.scince = scince;
    }
}