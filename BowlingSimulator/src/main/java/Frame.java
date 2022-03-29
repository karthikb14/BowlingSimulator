import Exceptions.InvalidInputException;

public class Frame {

    private Integer bonusScore = 0;     // bonus represents the bonus value that is got from successive rolls
    private Integer firstRollScore;
    private Integer secondRollScore;

    // returns if there is a strike in the current Frame
    public boolean isStrike() {
        return firstRollScore == 10;
    }

    // returns if there is a spare in the current frame
    public boolean isSpare() {
        return (firstRollScore + (secondRollScore == null ? 0 : secondRollScore)) == 10;
    }

    protected void updateFirstRollScore(int score) {
        validate(score);
        firstRollScore = score;
    }

    protected void updateSecondRollScore(int score) {
        validate(score);
        secondRollScore = score;
    }

    private void validate(int score) {
        if (score < 0 || score > 10)
            throw new InvalidInputException();
    }

    protected void addToBonus(int bonus) {
        bonusScore += bonus;
    }

    public int getScore() {
        return bonusScore + (firstRollScore == null ? 0 : firstRollScore) + (secondRollScore == null ? 0 : secondRollScore);
    }

    public boolean isFirstRollOfFrame() {
        return firstRollScore == null;
    }


}
