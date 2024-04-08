import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private boolean running;
    private final List<Token> tokens = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.running = true;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {

            if (game.isPlayersTurn(this)) {
                List<Token> extractedTokens = game.bag.extractTokens(1);
                if (!extractedTokens.isEmpty()) {
                    Token token = extractedTokens.getFirst();

                    tokens.add(token);
                    System.out.println(name + " picked token: " + token);
                    // aici cred ca as mai putea verifica daca se creaza o secventa
                    game.playerTurnFinished();
                } else {
                    System.out.println("OPS.....The bag is empty for player: " + name);
                    game.stopGame();
                    break;
                }
            }
        }
    }
}
