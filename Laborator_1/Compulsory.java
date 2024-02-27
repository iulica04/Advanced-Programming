public class Compulsory {
    public static void main(String[] args)
    {
        //1
        System.out.println("Hello Word");

        //2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        //3
        int n = (int)(Math.random()*1_000_000);

        //4
        int result = n*3;

        byte binary_number = 0b10101;
        result = result + binary_number;

        String hex = "FF";
        int hexToInt = Integer.parseInt(hex, 16);
        result += hexToInt;

        result *= 6;

        //5
        while(result > 10)
        {
            int newResult = 0;
            while(result != 0)
            {
                newResult += result%10;
                result /= 10;
            }

            result = newResult;
        }

        //6
        System.out.println("Willy - nilly, this semester I will learn " + languages[result]);
    }
}
