package dev.hektortm.soccer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void givenShootGoal_whenAddGoal_ReturnUpdatedNumberOfGoals() {
        Player p = new Player("Player", 23, 10, 10, 1, 1);
        p.addGoal();
        assertEquals(2, p.getTotalGoals());
    }


}
