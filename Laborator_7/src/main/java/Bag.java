import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private List<Token> tokens;

    // number va fi numarul maxim pentru crearea secventelor i1, i2, i3
    // dar exista mai multe jetoane de acelasi tip (pentru logica jocului)
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

    public synchronized List<Token> extractTokens (int howMany){
        List<Token> extracted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break; // Nu mai sunt token-uri în sac
            }
            int index = random.nextInt(tokens.size());
            Token token = tokens.remove(index);
            if (token == null) {
                System.out.println("No more tokens");
                break;
            }
            extracted.add(token);
        }
        return extracted;
    }
}
