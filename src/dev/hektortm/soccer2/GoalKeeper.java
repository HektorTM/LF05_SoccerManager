package dev.hektortm.soccer2;

import java.util.Random;

public class GoalKeeper extends Player {

    private int reaction;

    public GoalKeeper(String name, int age, int strength, int powerAtGoalKick, int motivation, int reaction) {
        super(name, age, strength, powerAtGoalKick, motivation, 0);
        this.reaction = reaction;
    }

    @Override
    public String toString() {
        return "\nGoal Keeper\n " +
                "Name: " + this.name +
                "\nAge: " + this.age +
                "\nStrength: " + this.strength +
                "\nPowerAtGoalKick: " + this.powerAtGoalKick +
                "\nMotivation: " + this.motivation +
                "\nReaction: " + this.reaction;

    }

    public boolean ballHold(int powerAtGoalKick) {
        Random rdm = new Random();
        int rdmVal = rdm.nextInt(-1, 1);
        this.reaction += rdmVal;

        if (this.reaction >= powerAtGoalKick) return true;
        else return false;
    }


}
