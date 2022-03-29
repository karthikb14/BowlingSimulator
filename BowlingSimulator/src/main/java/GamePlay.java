import java.util.List;

public class GamePlay {

    public static void main(String[] args) {
        Player firstPlayer = new Player(1, "John");
        //Player secondPlayer = new Player(2, "Jack");
        BowlingGame game = new BowlingGame(1, List.of(firstPlayer));
        game.startGame();
    }
}
