package basic;

import service.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean working = true;
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
