package dev.hektortm.soccer;

import dev.hektortm.soccer4.Coach;
import dev.hektortm.soccer4.GoalKeeper;
import dev.hektortm.soccer4.Player;
import dev.hektortm.soccer4.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {
    private Team dortmund;

    @BeforeEach
    public void setUp() {
        dev.hektortm.soccer4.Coach coach = new Coach("Terzic", 38, 5);
        GoalKeeper goalKeeper = new GoalKeeper("Bürki",30,7,2,10,7);

        dortmund = new Team("Borussia Dortmund", coach, goalKeeper);

        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Meunier", 29, 7, 5, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Akanji", 25, 8, 6, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Hummels", 31, 9, 5, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Guerreiro", 26, 8, 9, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Witsel", 31, 9, 6, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Brandt", 24, 9, 8, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Sancho", 20, 10, 8, 8, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Bellingham", 17, 7, 7, 7, 0));
        dortmund.addPlayer(new dev.hektortm.soccer4.Player("Reus", 31, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Haaland", 20, 9, 9, 8, 0));
    }

    @Test
    public void testGetTotalMotivation() {
        int totalMotivation = dortmund.getTotalMotivation();

        assertEquals(8, totalMotivation);
    }

}
