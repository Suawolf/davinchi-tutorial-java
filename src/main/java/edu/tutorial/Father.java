package edu.tutorial;

import java.util.Objects;

public class Father {
    private String name;

    public Father(String name) {
        this.name = name;
    }

    //In Spring, you can save this boilerplate by using @Data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        return Objects.equals(name, father.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    //MUST BE toString, but modified to see the difference
    public String prettyPrint() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }
}
