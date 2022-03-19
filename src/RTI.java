import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;

public class RTI {
    public int romanToInt(String s) {

        int output = 0;

        Map<String ,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);

        if(s.length()==0) return 0;
        if(s.length() ==1) return map.get(String.valueOf(s.charAt(0)));

        for(int i = 0;i<(s.length()-1);i++){
            if(map.get(String.valueOf(s.charAt(i)))>=
                    map.get(String.valueOf(s.charAt(i+1)))){
                output = output + map.get(String.valueOf(s.charAt(i)));
            }else{
                output = output - map.get(String.valueOf(s.charAt(i)));
            }
        }

        output = output + map.get(String.valueOf(s.charAt(s.length()-1)));
        return output;
    }

    public String IntToRoman(int s) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 1;i<=100;i++)
        {
            String val = "N";
            if(i<10){
                val = GetRomanNumber(i);
            }else if(i<100){
                String value = Integer.toString(i);
                val = GetDecimalNumber(Character.getNumericValue(value.charAt(0))) + GetRomanNumber(Character.getNumericValue(value.charAt(1)));
            }else val = "C";
            map.put(i,val);
        }

        return map.get(s);
    }

    private String GetRomanNumber(int x){
        String out = "";
        if(x == 1) out = "I";
        else if(x == 2) out = "II";
        else if(x == 3) out = "III";
        else if(x == 4) out = "IV";
        else if(x == 5) out = "V";
        else if(x == 6) out = "VI";
        else if(x == 7) out = "VII";
        else if(x == 8) out = "VIII";
        else if(x == 9) out = "IX";

        if(out.isEmpty()){
            return "";
        }else return out;

    }

    private String GetDecimalNumber(int x){
        String out = "";
        if(x == 1) out = "X";
        else if(x == 2) out = "XX";
        else if(x == 3) out = "XXX";
        else if(x == 4) out = "XL";
        else if(x == 5) out = "L";
        else if(x == 6) out = "LX";
        else if(x == 7) out = "LXX";
        else if(x == 8) out = "LXXX";
        else if(x == 9) out = "XC";

        if(out.isEmpty()){
            return "";
        }else return out;
    }
}
