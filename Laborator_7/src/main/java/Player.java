import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private boolean running;
    private final List<Token> tokens = new ArrayList<>();
    private int maxLength = 0;

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
        while (this.running && running) {
            synchronized (game) {
                try {
                    while (!game.isPlayersTurn(this)) {
                        game.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<Token> extractedTokens = game.bag.extractTokens(1);
                if (!extractedTokens.isEmpty()) {
                    Token token = extractedTokens.getFirst();

                    tokens.add(token);
                    TokenSorter.sortTokens(tokens);

                    // Check if the player has formed a sequence
                    List<Token> goodTokens = goodTokens();
                    int newMaxLength = maxLengthForSequence(goodTokens);
                    if (newMaxLength == game.getSequenceLength()) {
                        //this player wins
                        System.out.println("Player " + name + " wins!");
                        game.stopGame();
                        break;
                    }
                    else
                    {
                        if (newMaxLength > maxLength) {
                            System.out.println("Player " + name + " has a new sequence of length " + newMaxLength);
                            maxLength = newMaxLength;
                        }
                    }

                    game.playerTurnFinished();
                } else {
                    System.out.println("OPS... The bag is empty for player: " + name);
                    game.stopGame();
                    break;
                }
            }
        }
    }

    public List<Token> goodTokens() {
        List<Token> goodTokens = new ArrayList<>();
        for (Token token : tokens) {
            if (token.number1() + 1 == token.number2()) {
                goodTokens.add(token);
            }
        }

        return goodTokens;
    }

    public int maxLengthForSequence(List<Token> tokens) {
        for (int i = 0; i < tokens.size() - 1; i++) {
            if (tokens.get(i).number2() != tokens.get(i + 1).number1()) {
                return i + 1;
            }
        }
        return -1; // no sequence in the list
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getName() {
        return name;
    }
}
