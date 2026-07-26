package edu.tutorial;

public abstract class Human {
    GenderType gender;
    String name;

    void introduce() {
        System.out.println("Hello my name is: " + name);
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
