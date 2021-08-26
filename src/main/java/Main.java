import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    static String[] ending;
    static String[] dig1;
    static String[] dig20;
    static String[] dig100;
    static String[] digStandart;
    static boolean working = true;
    static {
        try {
            ending = Files.readAllLines(Paths.get("./src/main/resources/constant.txt")).get(1).split(" ");
            dig1 = Files.readAllLines(Paths.get("./src/main/resources/constant.txt")).get(2).split(" ");
            dig20 = Files.readAllLines(Paths.get("./src/main/resources/constant.txt")).get(3).split(" ");
            dig100 = Files.readAllLines(Paths.get("./src/main/resources/constant.txt")).get(4).split(" ");
            digStandart = Files.readAllLines(Paths.get("./src/main/resources/constant.txt")).get(5).split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (working)  System.out.println("Для выхода напишите: exit\n"+new Service().result(bufferedReader.readLine()));
    }
}
