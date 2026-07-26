package edu.tutorial;

public enum GenderType {
    MALE("M"),
    FEMALE("F");

    private final String name;

    GenderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
