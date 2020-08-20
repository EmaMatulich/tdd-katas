package christmaslights;

import java.util.List;

public class ChristmasLights {

    private static final String TURN_ON_INSTRUCTION = "turn on";
    private static final String TURN_OF_INSTRUCTION = "turn of";
    private static final String TOGGLE_INSTRUCTION = "toggle";

    private int lightsOn;
    private boolean[][] lights;

    public ChristmasLights(){
        lightsOn = 0;
        lights = new boolean[1000][1000];
    }

    public int getNumberOfLightsTurnOn(){
        return lightsOn;
    }

    public void processInstructions(List<String> instructions){
        for (String instruction: instructions){
            Instruction instructionCommand = new Instruction(instruction);
            process(instructionCommand);
        }
    }

    private void process(Instruction command) {
        if (command.getCommand().equals(InstructionCommand.TURN_ON)){
            for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
                for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                    if (!lights[i][j]){
                        lights[i][j] = true;
                        lightsOn++;
                    }
                }
            }
        }
        if (command.getCommand().equals(InstructionCommand.TURN_OFF)){
            for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
                for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                    if (lights[i][j]){
                        lights[i][j] = false;
                        lightsOn--;
                    }
                }
            }
        }

        if (command.getCommand().equals(InstructionCommand.TOGGLE)){
            for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
                for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                    if (lights[i][j]){
                        lights[i][j] = false;
                        lightsOn--;
                    }else {
                        lights[i][j] = true;
                        lightsOn++;
                    }
                }
            }
        }

    }


}
