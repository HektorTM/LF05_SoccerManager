package dev.hektortm.soccer;

public class SoccerManagerUI {
    public static void main(String[] args) {
        Coach c = new Coach("Jeff", 35, 5);
        System.out.println(c);

        Player p = new Player("Manfred", 39, 8, 10, 7, 1);
        System.out.println(p);
        p.shootAtGoal();
        p.shootAtGoal();
        p.shootAtGoal();
        p.addGoal();

        System.out.println(p);
    }
}
