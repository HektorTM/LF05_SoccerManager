package dev.hektortm.soccer;

public class Coach {
    private String name;
    private int age;
    private int experience;

    public Coach(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = validate(experience);
    }

    @Override
    public String toString() {
        return "\nCoach\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nexperience: " + this.experience;
    }

    public int validate(int value) {
        if (value > 10) return 10;
        if (value < 0) return 1;
        else return value;
    }

    public int getExperience() {
        return experience;
    }

}
