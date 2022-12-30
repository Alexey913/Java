// Семинар 2 - задача 1.1
// Создать абстрактный класс User и его наследники Student и Teacher 
// родитель имеет в себе общие данные (фио, год рождения, паспорт (серия и номер)),
// а наследники - собственные параметры (номер группы для Student, кафедра для Teacher)


package data;

public abstract class User {
    
    private String fio;
    private int birthYear;
    private long passport;
    private int id;

    public User(String fio, int birthYear, long passport, int id) {
        this.fio = fio;
        this.birthYear = birthYear;
        this.passport = passport;
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public long getPassport() {
        return passport;
    }
    public void setPassport(long passport) {
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
