package dev.hektortm.soccer5;

public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name,  int age) {
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return this.name;
    }

    protected int getAge() {
        return this.age;
    }
}
