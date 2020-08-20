package christmaslights;

public enum InstructionCommand {

    TURN_ON("turn on"),
    TURN_OFF("turn off"),
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
                TURN_OFF.getCommand().equals(instructionCommand) ||
                TOGGLE.getCommand().equals(instructionCommand);
    }

    public static InstructionCommand getInstructionCommandFromCommand(String command){
        if (TURN_ON.getCommand().equals(command)){return TURN_ON;}
        if (TURN_OFF.getCommand().equals(command)){return TURN_OFF;}
        if (TOGGLE.getCommand().equals(command)){return TOGGLE;}
        return null;
    }

}
