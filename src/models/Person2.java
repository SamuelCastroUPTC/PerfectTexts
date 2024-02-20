package models;

public class Person2 {

    private String name;
    private String lastname;
    private String code;
    private char gender;
    private int weigth;
    private int salary;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getGender() {
        return String.valueOf(gender);
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getWeigth() {
        return weigth;
    }
    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    
}
