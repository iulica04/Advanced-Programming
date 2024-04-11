import java.util.Comparator;
import java.util.List;

public class TokenSorter {

    public static void sortTokens(List<Token> tokens) {
        tokens.sort(new TokenComparator());
    }

    private static class TokenComparator implements Comparator<Token> {
        @Override
        public int compare(Token token1, Token token2) {
            if (token1.number1() != token2.number1()) {
                return Integer.compare(token1.number1(), token2.number1());
            }
            return Integer.compare(token1.number2(), token2.number2());
        }
    }
}