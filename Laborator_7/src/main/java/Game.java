import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.github.javafaker.Faker;

public class Game {
    Bag bag;
    List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    int sequenceLength;
    private Thread timeKeeperThread;

    public Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sequence length: ");
        sequenceLength = scanner.nextInt();
        this.bag = new Bag(sequenceLength);
    }

    public int getSequenceLength() {
        return sequenceLength;
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

        timeKeeperThread = new Thread(new TimeKeeper(10000)); // 10 seconds time limit
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();
    }

    public void stopGame() {
        System.out.println("The game has stopped.");
        for (Player player : players) {
            player.stop();
            notifyAll();
        }

        int max=0;
        String winner = "";
        for(Player player : players){
            if(player.getMaxLength() > max){
                max = player.getMaxLength();
                winner = player.getName();
            }
        }

        System.out.println("Winner is " + winner + " with a sequence of length " + max);
    }

    public synchronized boolean isPlayersTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex;
    }

    public synchronized void playerTurnFinished() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        notifyAll();
    }


    public static void main(String[] args){
        Game game = new Game();
        Faker fake = new Faker();

        for(int i=0; i<2; i++){
            game.addPlayer(new Player(fake.name().fullName()));
        }
        game.play();
    }
}
