package dev.hektortm.soccer4;

import java.util.ArrayList;

public class Team {
    private String name;
    private Coach coach;
    private GoalKeeper goalKeeper;
    private ArrayList<Player> squad;

    public Team(String name, Coach coach, GoalKeeper goalKeeper) {
        this.name = name;
        this.coach = coach;
        this.goalKeeper = goalKeeper;
        this.squad = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        this.squad.add(player);
    }

    public int getTotalMotivation() {
        int mot = 0;
        if (this.squad == null) return this.goalKeeper.getMotivation();
        for (Player p : this.squad) {
            mot += p.getMotivation();
        }
        mot += this.goalKeeper.getMotivation();

        int count = this.squad.size() + 1;

        mot = mot / count;
        return mot;
    }

    public int getTotalForce() {
        int force = 0;

        for (Player p : this.squad) {
            force += p.getForce();
        }
        return force;
    }

    public String toString() {
        String nl = "\n";
        String header = "***Mannschaft***";
        String coach = "Trainer: "+ this.coach.getName();
        String goalKeeper = "Torhüter: "+this.goalKeeper.getName();
        StringBuilder builder = new StringBuilder();
        for (Player p : squad) {
            builder.append("Spieler: " + p.getName() + "\n");
        }

        return header + nl +
                coach + nl +
                goalKeeper + nl +
                builder;

    }

    public String getName() {
        return this.name;
    }
}
