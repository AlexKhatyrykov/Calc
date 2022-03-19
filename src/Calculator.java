import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        StringParser sp = new StringParser();
        Evaulation ev = new Evaulation();
        RTI rti = new RTI();
        Scanner scanner = new Scanner(System.in);
        String chars = "AaBbCcDdEeFfGgHhJjKkLlMmNnOoPpQqRrSsTtUuWwYyZz:;*&!@#$%\"\',.\\\\";
        char currentCharacter;
        boolean charsPresent = false;

        String s1 = scanner.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            currentCharacter = s1.charAt(i);
            if (chars.contains(String.valueOf(currentCharacter))) {
                charsPresent = true;
            }
        }
        if(s1.length() == 0 || s1.length() < 5 || charsPresent){
            throw new ClassCastException("Неподходящий формат введенной строки");
        }
        int[] s2 = sp.GetArray(s1);

        if(sp.IsItRoman(s1))
        {
            int result = ev.Evaulate(s1, s2);
            String RomanResult = rti.IntToRoman(result);
            System.out.print(RomanResult);
        }else {
            int result = ev.Evaulate(s1, s2);
            System.out.print(result);
        }
    }
}
