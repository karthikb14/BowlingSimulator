import java.util.List;

public class BowlingGame {

    int noOfPlayers;
    List<Player> players;
    GamePrinter printer;
    GameController controller;
    PlayerConsole console;

    public BowlingGame(int noOfPlayers, List<Player> players) {
        this.noOfPlayers = noOfPlayers;
        this.players = players;
        this.printer = GamePrinter.getInstance();
        this.console = PlayerConsole.getInstance();
        controller = new GameController(players, printer, console);
    }

    public void startGame() {
        printer.startGame();
        controller.playGame();
    }
}
