package christmaslights;

public enum InstructionCommand {

    TURN_ON("turn on"),
    TURN_OF("turn of"),
    TOGGLE("toggle");

    private InstructionCommand(String command){
        this.command = command;
    }

    private String command;

    public String getCommand(){
        return this.command;
    }

    public static boolean isValidInstructionCommand(String instructionCommand){
        return TURN_ON.getCommand().equals(instructionCommand) ||
                TURN_OF.getCommand().equals(instructionCommand) ||
                TOGGLE.getCommand().equals(instructionCommand);
    }

}
