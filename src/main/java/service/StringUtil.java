package service;

public class StringUtil {
     static String deleteFirsZero(String enter){
        if (enter.startsWith("0")){
            enter= enter.substring(1);
            return deleteFirsZero(enter);
        }
        else return enter;
    }
    static String removingUnnecessaryCharacters(String enter){
        enter = enter.replaceAll("\"\"", "");
        enter = enter.replaceAll(" {2}", " ");
        enter = enter.replaceAll(" ноль ", " ");
        return enter;
    }
}
