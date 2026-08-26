package edu.tutorial.classes;

import java.util.List;

public class Contact {

    List<String> phones;
    Long age;
    String name;

    public Contact(List<String> phones, Long age) {
        this.phones = phones;
        this.age = age;
        this.name = "John Doe " + age;
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

    @Override
    public String toString() {
//        return "Person{ name=" + name + "phones=" + phones + ", age=" + age + '}';
        return "Person{" + name + '}';
    }

}
