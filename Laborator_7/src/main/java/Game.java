import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.github.javafaker.Faker;

public class Game {
    Bag bag;
    List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;

    public Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sequence length: ");
        int number = scanner.nextInt();
        this.bag = new Bag(number);
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void play(){
        for(Player player : players){
            Thread thread = new Thread(player);
            thread.start();
        }
    }

    public void stopGame() {
        System.out.println("The game has stopped.");
        for (Player player : players) {
            player.stop();
        }
    }

    public synchronized boolean isPlayersTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex;
    }

    public synchronized void playerTurnFinished() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }


    public static void main(String[] args){
        Game game = new Game();
        Faker fake = new Faker();

        for(int i=0; i<5; i++){
            game.addPlayer(new Player(fake.name().fullName()));
        }
        game.play();
    }
}
