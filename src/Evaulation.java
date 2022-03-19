public class Evaulation {
    public int Evaulate(String Exp, int[] Cyphers){
        int result = 0;

        if(Plus(Exp)){
            for(int i = 0; i<Cyphers.length; i++){
                if(Cyphers[i] > 10 || Cyphers[i] < 1){
                    throw new ClassCastException("Введенные числа должны быть от 1 до 10 включительно");
                }
                result = result + Cyphers[i];
            }
        }else if(Minus(Exp)){
            result = Cyphers[0];
            for(int i = 1; i<Cyphers.length; i++){
                if(Cyphers[i] > 10 || Cyphers[i] < 1){
                    throw new ClassCastException("Введенные числа должны быть от 1 до 10 включительно");
                }
                result = result - Cyphers[i];
            }
        }else if(Division(Exp)){
            result = Cyphers[0];
            for(int i = 1; i<Cyphers.length; i++){
                if(Cyphers[i] > 10 || Cyphers[i] < 1){
                    if(i == Cyphers.length - 1 && Cyphers[i] == 0){
                        throw new ClassCastException("На 0 делить нельзя");
                    }else throw new ClassCastException("Введенные числа должны быть от 1 до 10 включительно");
                }

                result = result / Cyphers[i];
            }
        }else if(Multi(Exp)){
            result = Cyphers[0];
            for(int i = 1; i<Cyphers.length; i++){
                if(Cyphers[i] > 10 || Cyphers[i] < 1){
                    throw new ClassCastException("Введенные числа должны быть от 1 до 10 включительно");
                }

                result = result * Cyphers[i];
            }
        }

        return result;
    }

    private boolean Plus(String s){
        return s.indexOf("+") > 0;
    }

    private boolean Minus(String s){
        return s.indexOf("-") > 0;
    }

    private boolean Division(String s){
        return s.indexOf("/") > 0;
    }

    private boolean Multi(String s){
        return s.indexOf("*") > 0;
    }
}
