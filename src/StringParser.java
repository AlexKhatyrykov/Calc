import java.util.regex.*;

public class StringParser {
    public int[] GetArray(String s1) throws Exception {
        int count = 0;
        int firstnum = 0;
        int endnum = 0;

        CheckExpression(s1);
        if(s1.indexOf(".") >= 0 || s1.indexOf(",") >= 0){
            throw new Exception("Необходимо вводить только целые числа");
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                endnum = i;
                int isit = 0;
                try {
                    isit = ConvertToInt(s1.substring(firstnum, endnum));
                    count++;
                    firstnum = endnum + 1;
                }catch (Exception e){
                    firstnum = i + 1;
                    continue;
                }
            } else if (i == s1.length() - 1) {
                int isit = 0;
                try {
                    isit = ConvertToInt(s1.substring(firstnum, s1.length()));
                    count++;
                }catch (Exception e){
                    firstnum = i + 1;
                    continue;
                }
            }
        }
        int[] arr = new int[count];
        if(count == 0){
            return arr;
        }

        count = 0;
        firstnum = 0;
        endnum = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                endnum = i;
                String currentString = s1.substring(firstnum, endnum);
                int isit = 0;
                try {
                    isit = ConvertToInt(currentString);
                }catch (Exception e){
                    continue;
                }
                if (isit > 0) {
                    arr[count] = isit;
                    count++;
                    firstnum = endnum + 1;
                }else{
                    firstnum++;
                }
            } else if (i == s1.length() - 1) {
                firstnum++;
                int isit = 0;
                try {
                    isit = ConvertToInt(s1.substring(firstnum, s1.length()));
                    arr[count] = isit;
                }catch (Exception e){
                    continue;
                }
            }
        }

        return arr;
    }

    private void CheckExpression(String s){
        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(s);
        if ((s.indexOf("I") >= 0 || s.indexOf("V") >= 0 || s.indexOf("X") >= 0)
        && matcher.find()){
            throw new ClassCastException("Нельзя вводить одновременно арабские и римские цифры");
        }
    }

    private int ConvertToInt(String s) throws Exception {
        RTI rti = new RTI();
        boolean bool = false;
        String s1 = s.trim();

        if(IsItRoman(s1)){
            int num = rti.romanToInt(s1);
            return num;
        }else{
            bool = true;
            for (int i = 0; i < s1.length(); i++){


                if(Character.isDigit(s1.charAt(i))){
                    continue;
                }else{
                    bool = false;
                }
            }

            if(bool){
                return Integer.parseInt(s1);
            }else {
                throw new Exception("Введенные данные не содержат выражений");
            }
        }
    }

    public boolean IsItRoman(String roman){
        return roman.indexOf("X")>=0 || roman.indexOf("I")>=0 || roman.indexOf("V")>=0 || roman.indexOf("M")>=0 || roman.indexOf("i")>=0 || roman.indexOf("v")>=0 || roman.indexOf("m")>=0 || roman.indexOf("x")>=0;
    }
}
