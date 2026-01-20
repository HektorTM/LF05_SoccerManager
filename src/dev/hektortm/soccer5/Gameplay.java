package dev.hektortm.soccer5;

import java.util.Random;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME = 5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;
    private Game game;


    public Gameplay(Game game) {
        this.game = game;
    }

    private void doGameAction(Player player, GoalKeeper goalKeeper, int minute, Team team) {
        System.out.println(minute + ". Minute:");
        System.out.println("Chance fuer "+team.getName()+"...");
        System.out.println(player.getName()+" zieht ab");
        if (goalKeeper.ballHold(player.powerAtGoalKick)) {
            System.out.println(goalKeeper.getName()+" pariert glanzvoll.");
        } else {
            player.addGoal();
            if (team == game.getHomeTeam()) game.increaseHomeGoals();
            else if (team == game.getAwayTeam()) game.increaseAwayGoals();
            System.out.println("TOR!!! " + game.getScore() + " "+player.getName()+"("+player.getTotalGoals()+")");
        }
        System.out.println(" ");
    }

    private int calculateForceOfTheTeam(Team team) {
        Random rdm = new Random();
        int dif = rdm.nextInt(-3, 3);
        int force = 0;
        force += team.getTotalForce();
        force += team.getTotalMotivation();
        force += team.getTrainer().getExperience();
        force += dif;

        if (force < 1) return 1;
        return force;
    }

    private void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        Random rdm = new Random();
        Team home = game.getHomeTeam();
        Team away = game.getAwayTeam();


        int currentMinute = 0;
        int playTime = PLAYING_TIME + rdm.nextInt(0, MAX_ADDITIONAL_TIME);

        while(currentMinute < playTime) {
            int awayForce = calculateForceOfTheTeam(away);
            int homeForce = calculateForceOfTheTeam(home);
            int totalVal = homeForce+awayForce;
            int val = rdm.nextInt(0, totalVal);

            if (val > homeForce) {
                doGameAction(away.getRandomPlayer(), home.getGoalKeeper(), currentMinute, away);
            } else {
                doGameAction(home.getRandomPlayer(), away.getGoalKeeper(), currentMinute, home);
            }

            currentMinute++;
            delay();
        }

        System.out.println("Das Spiel ist aus!\n");
        System.out.println(game.getScore());


    }

}
