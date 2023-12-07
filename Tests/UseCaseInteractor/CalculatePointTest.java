package UseCaseInteractor;

import entity.Computer;
import entity.Player;
import org.junit.Test;
import use_case.calculate_point.*;

import static org.junit.Assert.assertEquals;

public class CalculatePointTest {

    @Test
    public void testAddPoints(){
        Computer computer = new Computer("easy");
        Player player = new Player(0);
        CalculatePointInputData calculatePointInputData = new CalculatePointInputData(true, true, 5,4);
        int playerPoints = 100/5;
        int computerPoints = 100/4;

        CalculatePointInputBoundary calculatePointInteractor = new CalculatePointInteractor(player, computer);
        calculatePointInteractor.execute(calculatePointInputData);
        assertEquals(playerPoints, player.getTotalPoints());
        assertEquals(computerPoints, computer.getTotalPoints2());
        }




    }


