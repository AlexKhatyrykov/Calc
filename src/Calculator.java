import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        StringParser sp = new StringParser();
        Evaulation ev = new Evaulation();

        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        int[] s2 = sp.GetArray(s1);

        int result = ev.Evaulate(s1, s2);
        System.out.print("Result is: " + result);
    }
}
