import java.util.ArrayList;

public class Homework {

    public static int kReductibil(int number)
    {
        while(number >= 10)
        {
            String stringNumber = String.valueOf(number);
            int lengthOfNumber = stringNumber.length();
            int sumOfDigits = 0;
            for(int i=0; i<lengthOfNumber; i++)
            {
                int digit = Character.getNumericValue(stringNumber.charAt(i));
                sumOfDigits += digit * digit;
            }
            number = sumOfDigits;
        }

        return number;
    }
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        // Construim intervalul
        int minValue = Integer.parseInt(args[0]);
        int maxValue = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        ArrayList<String> kReductibleNumbers = new ArrayList<>();

        for(int i=minValue; i<=maxValue; i++)
        {
            if(kReductibil(i) == 1)
            {
               kReductibleNumbers.add(String.valueOf(i));
            }
        }

        for(String number : kReductibleNumbers)
        {
            System.out.println(number + " is a " + k + "-reductible.");
        }

        long stopTime = System.currentTimeMillis();
        System.out.println("Running time: " + (stopTime - startTime) + " ms.");
    }
}
