package edu.tutorial.classes;

import java.util.List;

public class Person {

    List<String> phones;
    Long age;
    String name;

    public Person(List<String> phones, Long age) {
        this.phones = phones;
        this.age = age;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
