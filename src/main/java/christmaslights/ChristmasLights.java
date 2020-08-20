package christmaslights;

import java.util.List;

public class ChristmasLights {

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
            process(new Instruction(instruction));
        }
    }

    private void process(Instruction command) {
        if (command.getCommand().equals(InstructionCommand.TURN_ON))
            processTurnOnCommand(command);
        if (command.getCommand().equals(InstructionCommand.TURN_OFF))
            processTurnOffCommand(command);
        if (command.getCommand().equals(InstructionCommand.TOGGLE))
            processToggleCommand(command);
    }

    private void processTurnOnCommand(Instruction command) {
        for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
            for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                turnOnLight(i, j);
            }
        }
    }

    private void processTurnOffCommand(Instruction command) {
        for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
            for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                turnOffLight(i, j);
            }
        }
    }

    private void processToggleCommand(Instruction command) {
        for  (int i = command.getStartingRow(); i<= command.getEndingRow(); i++){
            for (int j = command.getStartingColumn(); j<= command.getEndingColumn(); j++){
                if (lights[i][j]){
                    turnOffLight(i,j);
                }else {
                   turnOnLight(i,j);
                }
            }
        }
    }

    private void turnOnLight(int row, int column) {
        if (!lights[row][column]){
            lights[row][column] = true;
            lightsOn++;
        }
    }

    private void turnOffLight(int row, int column) {
        if (lights[row][column]){
            lights[row][column] = false;
            lightsOn--;
        }
    }


}
