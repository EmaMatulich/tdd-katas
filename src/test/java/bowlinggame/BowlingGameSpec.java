package bowlinggame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins.
 * The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.
 *
 * A spare is when the player knocks down all 10 pins in two rolls.
 * The bonus for that frame is the number of pins knocked down by the next roll.
 *
 * A strike is when the player knocks down all 10 pins on his first roll.
 * The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.
 *
 * In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame.
 * However no more than three balls can be rolled in tenth frame.
 */

/**
 Write a class named “Game” that has two methods
 roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
 score() : int is called only at the very end of the game.  It returns the total score for that game.
 */

public class BowlingGameSpec {

    private BowlingGame game;

    @Before
    public void setup(){
        game = new BowlingGame();
    }

    private void rollMany(int rolls, int pines){
        for (int i = 0; i< rolls; i++){
            game.roll(pines);
        }
    }
    private void rollSpare(){
        rollMany(2, 5);
    }
    private void rollStrike(){
        game.roll(10);
    }

    @Test
    public void WhenRoll0PinsInEachRollThenScoreIsZero(){
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void WhenRoll1PinsInEachRollThenScoreIs20(){
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void WhenRollOneSpareThenSpareBonusReceived(){
        rollSpare();
        rollMany(1, 3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void WhenRollOneStrikeThenStrikeBonusReceived(){
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void WhenRollPerfectGameThenScoreIs300(){
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    //tengo un strike o spare en la ultima posicion


}
