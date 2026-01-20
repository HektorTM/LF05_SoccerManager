package dev.hektortm.soccer5;

import java.util.Random;

public enum Actions {
    SHOOT, FOUL, YELLOW_CARD;

    public static Actions getRandomAction() {
        Random rdm = new Random();

        int rdmVal = rdm.nextInt(1, 10);

        if (rdmVal <= 8) return SHOOT;
        else return FOUL;
    }

}
