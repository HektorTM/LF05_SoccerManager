package dev.hektortm.soccer4;

public class Game {
    private Team home;
    private Team away;
    private int goalsHome;
    private int goalsAway;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
        this.goalsHome = 0;
        this.goalsAway = 0;
    }

    public void increaseHomeGoals() {
        this.goalsHome += 1;
    }

    public void increaseAwayGoals() {
        this.goalsAway += 1;
    }

    public String toString() {
        return this.away.getName() + " - " + this.home.getName();
    }

    public String getScore() {
        return this.away.getName() + " " + this.goalsAway + " - " + this.goalsHome + " " + this.home.getName();
    }
}
