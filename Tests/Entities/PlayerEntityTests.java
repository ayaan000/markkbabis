package Entities;

import entity.Game;
import entity.GameStats;
import entity.Player;
import entity.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerEntityTests {
    @Before
    public void init() {
        Player player = new Player(10);
    }
    @Test
    public void testGetTotalPoints() {
        Player player = new Player(10);
        assertEquals(10, player.getTotalPoints());
    }

    @Test
    public void testSetTotalPoints() {
        Player player = new Player(10);
        player.setAdditionalPoints(10);
        assertEquals(20, player.getTotalPoints());
    }
}
