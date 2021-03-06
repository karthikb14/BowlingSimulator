import Exceptions.InvalidInputException;

public class Player {

    private static int MAX_FRAMES = 10;

    int playerId;
    String playerName;
    int currentFrame;
    PlayerConsole inputConsole;

    Frame[] scoreFrames = new Frame[11]; // 10 frames per player; 11th frame is the bonus frame

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        currentFrame = 0;
        createFrames();
    }
    
    private void createFrames() {
        for (int i=0; i< scoreFrames.length; i++) {
            scoreFrames[i] = new Frame();
        }
    }

    private Frame getCurrentFrame() {
        return scoreFrames[currentFrame];
    }

    private Frame getPreviousFrame() {
        return currentFrame > 0 ? scoreFrames[currentFrame - 1] : null;
    }

    private int playFirstTurn() {
        return inputConsole.getPinsDown();
    }

    private void updateFirstRollScore(int score) {
        getCurrentFrame().updateFirstRollScore(score);
    }

    private void updateSecondRollScore(int score) {
        getCurrentFrame().updateSecondRollScore(score);
    }
    
    private boolean isBonusFrame() {
        return currentFrame == 10;
    }

    private int playSecondTurn(int validPinCount) {
        int score = inputConsole.getPinsDown();
        if (score > validPinCount) {
            throw new InvalidInputException();
        }
        return score;
    }

    // Main Logic for game play
    public void play(PlayerConsole console, GamePrinter printer) {
        this.inputConsole = console;
        int pinsLeft = 10;

        if (isBonusFrame()) {
            handleBonusFrame();
            return;
        }
            int firstTurnScore = playFirstTurn();
            pinsLeft -= firstTurnScore;
            handlePreviousFrame(firstTurnScore);
            updateFirstRollScore(firstTurnScore);
            if (getCurrentFrame().isStrike()) { // If strike
                printer.announceStrike();
                currentFrame++;
            } else { //
                int secondTurnScore = playSecondTurn(pinsLeft);
                if (firstTurnScore + secondTurnScore == 10) {
                    printer.announceSpare();
                }
                handlePreviousFrame(secondTurnScore);
                updateSecondRollScore(secondTurnScore);
                currentFrame++;
            }
    }
    
    private void handleBonusFrame() {
        int pinsLeft = 10;
        if(getPreviousFrame().isStrike() || getPreviousFrame().isSpare()) {
            int firstTurnScore = playFirstTurn();
            handlePreviousFrame(firstTurnScore);
            updateFirstRollScore(firstTurnScore);
        }
        if(getPreviousFrame().isStrike()) {
            int secondTurnScore = playSecondTurn(pinsLeft);
            handlePreviousFrame(secondTurnScore);
            updateSecondRollScore(secondTurnScore);
        }
    }    

// Add bonus to previous frame ony if previous frame is Strike
// If previous frame is Strike, add both rolls of successive frame
// Else if previous frame is Spare, add only first roll of successive frame
    private void handlePreviousFrame(int score) {
        if (currentFrame > 0) {
            if (getPreviousFrame() != null && (getPreviousFrame().isStrike() ||
                    (getPreviousFrame().isSpare() && getCurrentFrame().isFirstRollOfFrame()))) {
                getPreviousFrame().addToBonus(score);
            }
            // For successive strive scenario, bonus need to be added to previous - 1 frame also
            if (getPreviousFrame().isStrike() && currentFrame - 2 > 0 && scoreFrames[currentFrame - 2].isStrike() && 
                (getCurrentFrame().isFirstRollOfFrame() || isBonusFrame())) {
                scoreFrames[currentFrame - 2].addToBonus(score);
            }
        }
    }

    public int getScore() {
        int totalScore = 0;
        for (int i=0; i<scoreFrames.length - 1; i++) {
            totalScore += scoreFrames[i].getScore();
        }
        return totalScore;
    }
}
