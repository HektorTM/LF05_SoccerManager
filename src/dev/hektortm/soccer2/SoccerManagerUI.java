package dev.hektortm.soccer2;

public class SoccerManagerUI {
    public static void main(String[] args) {
        Coach c = new Coach("Jeff", 35, 5);
        System.out.println(c);

        Player p = new Player("Player1", 20, 8, 5, 5, 0);
        System.out.println(p);


        GoalKeeper g = new GoalKeeper("Manfred", 39, 8, 10, 7, 5);
        System.out.println(g);

        p.shootAtGoal();
        if (g.ballHold(p.getPowerAtGoalKick())) {
            System.out.println(g.getName() + ": Ball held");
        } else {
            System.out.println("ball not held");
            System.out.println(p.getName() + "+1 Goal");
            p.addGoal();
            System.out.println(p.getName() + "Total Goals: " + p.getTotalGoals());
        }

    }
}
