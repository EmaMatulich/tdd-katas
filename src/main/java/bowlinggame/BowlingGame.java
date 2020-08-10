package bowlinggame;

public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins){
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score(){
        int score = 0;
        int roll = 0;
        for (int frame=0; frame< 10; frame++){
            if (isStrikeFrame(roll)) {
                score += getStrikeScore(roll);
                roll++;
            } else if (isSpareFrame(roll)){
                score += getSpareScore(roll);
                roll += 2;
            }else{
                score += getFrameScore(roll);
                roll += 2;
            }
        }
        return score;
    }

    private int getFrameScore(int rollIndex){
        return rolls[rollIndex] + rolls[rollIndex+1];
    }

    private boolean isSpareFrame(int rollIndex){
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int getSpareScore(int rollIndex){
        return 10 + rolls[rollIndex+2];
    }

    private boolean isStrikeFrame(int rollIndex){
        return rolls[rollIndex] == 10;
    }

    private int getStrikeScore(int rollIndex){
        return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }
}
