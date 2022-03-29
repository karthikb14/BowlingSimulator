public class GamePrinter {

    private static GamePrinter printer;

    private GamePrinter() {

    }

    static public GamePrinter getInstance() {
        if (printer == null) {
            printer = new GamePrinter();
        }
        return printer;
    }

    public void startGame() {
        System.out.println("The game starts..");
    }

    public void announceStrike() {
        System.out.println("That's a STRIKE !!!");
    }

    public void announceSpare() {
        System.out.println("That's a SPARE !!");
    }

    public void EndOfGame() {
        System.out.println("Game Over");
    }

    public void winnerOfGame(String winnerName) {
        System.out.println("The winner is " + winnerName);
    }

    public void playerTurnStart(String name) {
        System.out.println("Turn for player " + name + " starts.");
    }

    public void playerTurnEnd(String name) {
        System.out.println("Turn for player " + name + " ends.");
    }

    public void winnerScore(int winningScore) {
        System.out.println("Winning score is: " + winningScore);
    }
}
