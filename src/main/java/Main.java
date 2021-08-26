import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    static String patchToDictionary = "./src/main/resources/constant.txt";
    static DictioinalLoader dictioinalLoader= new DictioinalLoader(patchToDictionary);
    static String[] ending = dictioinalLoader.gerEnding();
    static String[] dig1 = dictioinalLoader.gerDig1();
    static String[] dig20 = dictioinalLoader.getDig20();
    static String[] dig100 = dictioinalLoader.gerDig100();
    static String[] digStandart = dictioinalLoader.gerDigStandart();
    static boolean working = true;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для выхода напишите: exit");
        while (working)  {
            String digit = bufferedReader.readLine();
            if (!digit.equals("exit")){
                System.out.println( "Введите число >>\n" + new Service().TranslateNumbersToString(digit));
            }

            else working=false;
        }
    }
}
