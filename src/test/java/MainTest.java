import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
     Main main = new Main();

    @Test
    public void noNumber()  {
        String expected = "в переданной строке находятся буквенные значения, пожалуйста отредактируйте ваш запрос.";
        String comparison = Main.result("Not number");
       assertEquals(expected,comparison);
    }
    @Test
    public void tooBig()  {
        String expected = "Выключите пожалуйста залипание клавиш и попробуйте снова.";
        String comparison = Main.result("5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555" +
                "555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
        assertEquals(expected,comparison);
    }
    @Test
    public void zero() {
        String expected = "ноль ";
        String comparison = Main.result("0");
        assertEquals(expected,comparison);
    }

    @Test
    public void anyNumber() throws IOException {
        String expected ;
        String comparison ;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведите числовое значение");
        comparison = reader.readLine();
        System.out.println("введите строковое представление числе");
       expected = reader.readLine();
       comparison= Main.result(comparison);
        assertEquals(expected,comparison);
    }
}
