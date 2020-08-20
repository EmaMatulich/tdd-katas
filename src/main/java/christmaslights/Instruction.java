package christmaslights;

public class Instruction {

    private static final int TURN_INSTRUCTION_LENGTH = 4;
    private static final int TOGGLE_INSTRUCTION_LENGTH = 5;
    private static final int THROUGH_POSITION_FROM_INSTRUCTION_END = 2;


    private InstructionCommand command;
    private int startingRow;
    private int startingColumn;
    private int endingRow;
    private int endingColumn;

    public Instruction(String instruction) throws RuntimeException{
        String[] instructionArguments = instruction.split(" ");
        validateInstructionLength(instructionArguments);
        setInstructionCommand(extractInstructionCommand(instructionArguments));
        validateInstructionContainsThrough(instructionArguments);
        setInstructionStartingPoint(extractInstructionStartingPoint(instructionArguments));
        setInstructionEndingPoint(extractInstructionEndingPoint(instructionArguments));
    }

    private void validateInstructionLength(String[] instructionArguments) throws RuntimeException{
        if (!(instructionArguments.length  >= TURN_INSTRUCTION_LENGTH
                && instructionArguments.length <= TOGGLE_INSTRUCTION_LENGTH)){
            throw new RuntimeException("Invalid instruction");
        }
    }

    private String extractInstructionCommand(String[] instructionArguments){
        if (instructionArguments.length == TOGGLE_INSTRUCTION_LENGTH){
            return instructionArguments[0] + " " + instructionArguments[1];
        }
        return instructionArguments[0];
    }

    private void setInstructionCommand(String command) throws RuntimeException{
        if (!InstructionCommand.isValidInstructionCommand(command)){
            throw new RuntimeException("Invalid instruction: " + command);
        }
        this.command = InstructionCommand.getInstructionCommandFromCommand(command);
    }

    private void validateInstructionContainsThrough(String[] instructionArguments){
        int throughPosition = instructionArguments.length - THROUGH_POSITION_FROM_INSTRUCTION_END;
        if (!instructionArguments[throughPosition].equals("through")){
            throw new RuntimeException("Invalid instruction: through missing");
        }
    }

    private String extractInstructionStartingPoint(String[] instructionArguments){
        return instructionArguments[instructionArguments.length - 3];
    }

    private String extractInstructionEndingPoint(String[] instructionArguments){
        return instructionArguments[instructionArguments.length - 1];
    }

    private void setInstructionStartingPoint(String startingPoint) throws RuntimeException{
        String[] points = startingPoint.split(",");
        try{
            int row = new Integer(points[0]);
            int column = new Integer(points[1]);
            if (row >= 0 && column >= 0){
                this.startingRow = row;
                this.startingColumn = column;
                return;
            }
        }catch (NumberFormatException e){}
        throw new RuntimeException("Invalid instruction point: " + startingPoint);
    }

    private void setInstructionEndingPoint(String endingPoint) throws RuntimeException{
        String[] points = endingPoint.split(",");
        try{
            int row = new Integer(points[0]);
            int column = new Integer(points[1]);
            if (row >= 0 && column >= 0){
                this.endingRow = row;
                this.endingColumn = column;
                return;
            }
        }catch (NumberFormatException e){}
        throw new RuntimeException("Invalid instruction point: " + endingPoint);
    }


    public InstructionCommand getCommand() {
        return command;
    }

    public int getStartingRow() {
        return startingRow;
    }

    public int getStartingColumn() {
        return startingColumn;
    }

    public int getEndingRow() {
        return endingRow;
    }

    public int getEndingColumn() {
        return endingColumn;
    }
}
