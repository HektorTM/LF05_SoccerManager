package dev.hektortm.soccer2;

import java.util.Random;

public class Player {
    protected String name;
    protected int age;
    protected int strength;
    protected int powerAtGoalKick;
    protected int motivation;
    protected int numberOfGoals;

    public Player(String name, int age, int strength, int powerAtGoalKick, int motivation, int numberOfGoals) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.powerAtGoalKick = powerAtGoalKick;
        this.motivation = validate(motivation);
        this.numberOfGoals = numberOfGoals;
    }

    public int shootAtGoal() {
        Random rdm = new Random();
        int randomVal =  rdm.nextInt(-2, 1);

        this.powerAtGoalKick += randomVal;
        return validate(this.powerAtGoalKick);
    }

    @Override
    public String toString() {
        return "\nSpieler\n " +
                "Name: " + this.name +
                "\nAge: " + this.age +
                "\nStrength: " + this.strength +
                "\nPower At Goal Kick: " + this.powerAtGoalKick+
                "\nMotivation: " + this.motivation +
                "\nNumber of Goals: " + this.numberOfGoals;
    }

    public void addGoal() {
        this.numberOfGoals++;
    }

    protected int validate(int value) {
        if (value > 10) return 10;
        else if (value < 0) return 1;
        else return value;
    }

    public String getName() {
        return name;
    }

    public int getPowerAtGoalKick() {
        return powerAtGoalKick;
    }

    public int getTotalGoals() {
        return this.numberOfGoals;
    }

}
