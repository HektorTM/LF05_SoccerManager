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
        announceAction(minute, player, team);
        Actions action = Actions.getRandomAction();

        if (action == Actions.SHOOT) handleShootAction(team.getRandomPlayer(), goalKeeper, team);
        if (action == Actions.FOUL) handleFoul(team.getRandomPlayer(), getOppositeTeam(team).getRandomPlayer());

        System.out.println(" ");
    }

    private Team getOppositeTeam(Team initial) {
        if (initial == game.getAwayTeam()) return game.getHomeTeam();
        else return game.getAwayTeam();
    }

    private void handleShootAction(Player player, GoalKeeper gk, Team team) {
        boolean held = gk.ballHold(player.powerAtGoalKick);
        if (held) System.out.println(gk.getName() + " pariert glanzvoll!");
        else {
            player.addGoal();
            validateAddGoal(team);
            System.out.println("TOR!!! " + game.getScore() + " | "+player.getName()+"("+player.getTotalGoals()+")");
        }
    }

    private void handleFoul(Player vic, Player fouler) {
        System.out.println("FOUL! " + fouler.getName() + " fouled " + vic.getName() + "! Gelbe Karte!");
        vic.modifyMotivation(1, Operation.INCREASE);
        fouler.modifyMotivation(1, Operation.DECREASE);
    }

    private void validateAddGoal(Team team) {
        if (team == game.getHomeTeam()) game.increaseHomeGoals();
        else if (team == game.getAwayTeam()) game.increaseAwayGoals();
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

    private void announceAction(int minute, Player p, Team t) {
        System.out.println(minute + ". Minute:");
        System.out.println("Chance fuer "+t.getName()+"...");
        System.out.println(p.getName()+" zieht ab");
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

            currentMinute += rdm.nextInt(1, MAX_DURATION_UNTIL_NEXT_ACTION);
            delay();
        }

        System.out.println("Das Spiel ist aus!\n");
        System.out.println(game.getScore());
    }

}
