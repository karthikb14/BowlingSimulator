import java.util.List;

public class GameController {

    List<Player> players;
    GamePrinter printer;
    PlayerConsole console;

    public GameController(List<Player> players, GamePrinter printer, PlayerConsole console) {
        this.players = players;
        this.printer = printer;
        this.console = console;
    }

    public void playGame() {
        for (int i=0; i<11; i++) {
            for (Player player : players) {
                printer.playerTurnStart(player.playerName);
                player.play(console, printer);
                printer.playerTurnEnd(player.playerName);
            }
        }
        printer.EndOfGame();
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }

        printer.winnerOfGame(winner.playerName);
        printer.winnerScore(winner.getScore());
    }
}
