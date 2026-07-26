package edu.tutorial;

import java.util.Objects;

@InfoAuthor(name = "Suawolf", email = "suawolf@email.com")
public class Father extends Human {
    private String name;

    public Father(String name) {
        this.name = name;
        this.gender = GenderType.MALE;
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
    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }
}
