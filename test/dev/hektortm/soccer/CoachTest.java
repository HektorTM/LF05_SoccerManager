package dev.hektortm.soccer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoachTest {

    @Test
    public void giveExperienceHigher10_WhenValidate_Return10() {
        Coach c = new Coach("Coach", 84, 11);
        assertEquals(10, c.getExperience());
    }

    @Test
    public void giveExperienceLower1_WhenValidate_Return1() {
        Coach c = new Coach("Coach", 84, -1);
        assertEquals(1, c.getExperience());
    }

    @Test
    public void giveExperience7_WhenValidate_Return7() {
        Coach c = new Coach("Coach", 70, 7);
        assertEquals(7, c.getExperience());
    }

}
