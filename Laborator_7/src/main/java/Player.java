import java.util.List;

public class Player extends Thread{
    private String name;
    Game game;
    private List<Token> tokens;

    public Player(String name)
    {
        this.name = name;
    }

    @Override
    public void run(){
        while(true){
            List<Token> extractedTokens = game.bag.extractTokens(1);
            if(extractedTokens.isEmpty()){
                System.out.println("OPS.....The bag is empty.");
                break;
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
