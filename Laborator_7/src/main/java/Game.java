import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.github.javafaker.Faker;

public class Game {
    Bag bag;
    List<Player> players = new ArrayList<>();

    public Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sequence lenght: ");
        int number = scanner.nextInt();
        this.bag = new Bag(number);
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void play(){
        for(Player player : players){
            player.start();
        }
    }


    public static void main(String[] args){
        Game game = new Game();
        Faker fake = new Faker();

        for(int i=0; i<10; i++){
            game.addPlayer(new Player(fake.name().fullName()));
        }
        game.play();
    }
}
