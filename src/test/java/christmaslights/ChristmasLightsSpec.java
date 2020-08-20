package christmaslights;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Probably a Fire Hazard
 * Because your neighbors keep defeating you in the holiday house decorating contest year after year,
 * you’ve decided to deploy one million lights in a 1000x1000 grid. Furthermore,
 * because you’ve been especially nice this year, Santa has mailed you instructions
 * on how to display the ideal lighting configuration:
 *
 * Lights in your grid are numbered from 0 to 999 in each direction;
 *
 * the lights at each corner are at 0,0, 0,999, 999,999, and 999,0.
 *
 * The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs.
 *
 * Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square.
 *
 * The lights all start turned off.
 *
 * To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.
 *
 * turn on 0,0 through 999,999 would turn on (or leave on) every light.
 * toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
 * turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
 * After following the instructions, how many lights are lit?
 */

public class ChristmasLightsSpec {

    @Rule
    public ExpectedException  expectedException = ExpectedException.none();
    private ChristmasLights lights;
    List<String> instructions;

    @Before
    public void setUp(){
        lights = new ChristmasLights();
        instructions = new ArrayList<>();
    }


    @Test
    public void whenChristmasLightsInstantiatedThen0LightsOn(){
        Assert.assertEquals(0, lights.getNumberOfLightsTurnOn());
    }

    @Test
    public void GivenOneInvalidInstructionStartWhenProcessInstructionThenRuntimeException(){
        instructions.add("qwoeqwiueqwe");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenOneTurnOnFollowbyInvalidBeginInstructWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn on 0,0 through 999,999");
        instructions.add("qwoeqwiueqwe");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenOneTurnOfFollowbyInvalidBeginInstructWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 through 999,999");
        instructions.add("qwoeqwiueqwe");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenOneToggleFollowbyInvalidBeginInstructWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 through 999,999");
        instructions.add("turn on 0,0 through 999,999");
        instructions.add("toggle 0,0 through 999,999");
        instructions.add("qwoeqwiueqwe");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenFirstNumberFromFirstPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of -1,0 through 999,999");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: -1,0");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenSecondNumberFromFirstPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,-1 through 999,999");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: 0,-1");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenLetterInFirstPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of a,0 through 999,999");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: a,0");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenFirstNumberFromSecondPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 through -999,999");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: -999,999");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenSecondNumberFromSecondPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 through 999,-999");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: 999,-999");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenLetterInSecondPairNegativeWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 through 999,a");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction point: 999,a");
        lights.processInstructions(instructions);
    }

    @Test
    public void GivenInstructionWithoutThroughWhenProcessInstrucThenRuntimeException(){
        instructions.add("turn of 0,0 ssss 999,0");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid instruction: through missing");
        lights.processInstructions(instructions);
    }

}
