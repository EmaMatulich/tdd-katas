package christmaslights;

import java.util.List;

public class ChristmasLights {

    private static final String TURN_ON_INSTRUCTION = "turn on";
    private static final String TURN_OF_INSTRUCTION = "turn of";
    private static final String TOGGLE_INSTRUCTION = "toggle";

    public int getNumberOfLightsTurnOn(){
        return 0;
    }

    public void processInstructions(List<String> instructions){
        for (String instruction: instructions){
            Instruction instructionCommand = new Instruction(instruction);
        }
    }


}
