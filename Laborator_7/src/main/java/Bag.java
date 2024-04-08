import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Token> tokens;
    Object lock = new Object();

    public Bag(int number) {
        tokens = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < number; i++) {
            for(int j=i+1; j<=number; j++){
                int numberOfTokens = random.nextInt(5) + 1;
                while (numberOfTokens != 0) {
                    tokens.add(new Token(i, j));
                    numberOfTokens--;
                }
            }
        }

        int numberOfTokens = random.nextInt(5) + 1;
        while (numberOfTokens != 0) {
            tokens.add(new Token(number, 1));
            numberOfTokens--;
        }
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            int index = random.nextInt(tokens.size());
            Token token = tokens.get(index);
            if (token == null) {
                System.out.println("No more tokens");
                break;
            }
            extracted.add(token);
            tokens.remove(token);
        }
        return extracted;
    }

    public void printTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(i + "----->" + tokens.get(i).number1() + "      " + tokens.get(i).number2());
        }
    }

}
