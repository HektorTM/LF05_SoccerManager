package dev.hektortm.soccer4;

import java.util.Random;

public class Player extends Person {
    protected int force;
    protected int powerAtGoalKick;
    protected int motivation;
    protected int numberOfGoals;

    public Player(String name, int age, int force, int powerAtGoalKick, int motivation, int numberOfGoals) {
        super(name, age);
        this.force = force;
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
                "\nStrength: " + this.force +
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

    public int getMotivation() {
        return this.motivation;
    }

    public int getForce() {
        return this.force;
    }
}
