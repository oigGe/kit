package georggross;

public class Checker {

    public static boolean isValidName(String name){
        for(int i = 0; i < name.length();i++){
            if (!Character.isLetter(name.charAt(i))){
                return false;
            }
        }return true;
    }





}
