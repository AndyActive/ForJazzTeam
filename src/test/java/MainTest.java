import basic.DictioinalLoader;
import org.junit.jupiter.api.Test;
import service.Service;

import java.io.IOException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    // тест для исключения
    @Test
    public void testCreateTempFile() {
        Throwable thrown = assertThrows(IOException.class, () -> new DictioinalLoader("any path except ./src/main/resources/constant.txt1"));
        assertNotNull(thrown.getMessage());
    }
    @Test
    public void commaSeparatedNumber()  {
        String expected = "девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять ";
        String comparison =new Service().TranslateNumbersToString("999,999,99");
        assertEquals(expected,comparison);
    }
//тест для исключения
    @Test
    public void noNumber()  {
        String expected = "в переданной строке находятся буквенные значения, пожалуйста отредактируйте ваш запрос.";
        String comparison =new Service().TranslateNumbersToString("Not number");
       assertEquals(expected,comparison);
    }
    @Test
    public void tooBig()  {
        String expected = "Выключите пожалуйста залипание клавиш и попробуйте снова.";
        String comparison = new Service().TranslateNumbersToString("5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555" +
                "555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
        assertEquals(expected,comparison);
    }
    @Test
    public void zero() {
        String expected = "Ноль ";
        String comparison = new Service().TranslateNumbersToString("0");
        assertEquals(expected,comparison);
    }

    @Test
    public void anyNumber()  {
        Map<String, String> test1 = Map.of(
                "334", "триста тридцать четыре ",//
                "1029", "одна тысяча двадцать девять ",//
                "2818", "две тысячи восемьсот восемнадцать ",
                "10001", "десять тысяч один ",
                "645984978947897489464156897495614798748974665498498", "шестьсот сорок пять квиндециллионов девятьсот восемьдесят четыре кваттуордециллионов девятьсот семьдесят восемь тредециллионов девятьсот сорок семь дуодециллионов восемьсот девяносто семь ундециллионов четыреста восемьдесят девять дециллионов четыреста шестьдесят четыре нониллионов сто пятьдесят шесть октиллионов восемьсот девяносто семь септиллионов четыреста девяносто пять секстиллионов шестьсот четырнадцать квинтиллионов семьсот девяносто восемь квадриллионов семьсот сорок восемь триллионов девятьсот семьдесят четыре миллиардов шестьсот шестьдесят пять миллионов четыреста девяносто восемь тысяч четыреста девяносто восемь ",
                "456488", "четыреста пятьдесят шесть тысяч четыреста восемьдесят восемь ",//
                "458011", "четыреста пятьдесят восемь тысяч одиннадцать ",//
                "888896522", "восемьсот восемьдесят восемь миллионов восемьсот девяносто шесть тысяч пятьсот двадцать два ",//
                "5895468468416", "пять триллионов восемьсот девяносто пять миллиардов четыреста шестьдесят восемь миллионов четыреста шестьдесят восемь тысяч четыреста шестнадцать "//
        );
        for (String key : test1.keySet()) {
            assertEquals(test1.get(key), new Service().TranslateNumbersToString(key));
            System.out.println(test1.get(key)+" : "+new Service().TranslateNumbersToString(key));
        }

    }
}
