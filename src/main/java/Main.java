import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] dig1 = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "одна", "две", ""};

    static String[] dig20 = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто", ""};

    static String[] dig100 = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот", ""};

    static String[] digStandart = {"тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион", "секстиллион", "септиллион", "октиллион",
            "нониллион", "дециллион", "ундециллион", "дуодециллион", "тредециллион", "кваттуордециллион", "квиндециллион", "сексдециллион", "септдециллион",
            "октодециллион", "новемдециллион", "вигинтиллион", "унвигинтиллион", "дуовигинтиллион", "тревигинтиллион", "кваттуорвигинтиллион", "квинвигинтиллион",
            "сексвигинтиллион", "септенвигинтиллион", "октовигинтиллион", "новемвигинтиллион", "тригинтиллион", "унтригинтиллион", "дуотригинтиллион", "третригинтиллион",
            "кваттуортригинтиллион", "квинтригинтиллион", "секстригинтиллион", "септентригинтиллион", "октотригинтиллион", "новемтригинтиллион", "квадрагинтиллион",
            "унквадрагинтиллион", "дуоквадрагинтиллион", "треквадрагинтиллион", "кваторквадрагинтиллион", "квинквадрагинтиллион", "сексквадрагинтиллион", "септенквадрагинтиллион", "октоквадрагинтиллион", "новемквадрагинтиллион",
            "квинквагинтиллион", "унквинкагинтиллион", "ундециллион", "дуоквинкагинтиллион", "треквинкагинтиллион", "кваторквинкагинтиллион", "квинквинкагинтиллион", "сексквинкагинтиллион", "септенквинкагинтиллион",
            "октоквинкагинтиллион", "новемквинкагинтиллион", "сексагинтиллион", "унсексагинтиллион", "дуосексагинтиллион", "тресексагинтиллион", "кваторсексагинтиллион", "квинсексагинтиллион",
            "секссексагинтиллион", "септенсексагинтиллион", "октосексагинтиллион", "новемсексагинтиллион", "септагинтиллион", "унсептагинтиллион", "дуосептагинтиллион", "тресептагинтиллион",
            "кваторсептагинтиллион", "квинсептагинтиллион", "секссептагинтиллион", "септенсептагинтиллион", "октосептагинтиллион", "новемсептагинтиллион", "октогинтиллион", "", "уноктогинтиллион", "дуооктогинтиллион", "треоктогинтиллион", "кватороктогинтиллион", "квиноктогинтиллион",
            "сексоктогинтиллион", "септоктогинтиллион", "октооктогинтиллион", "новемоктогинтиллион", "нонагинтиллион", "дуононагинтиллион", "тренонагинтиллион", "кваторнонагинтиллион",
            "квиннонагинтиллион", "секснонагинтиллион", "септеннонагинтиллион", "октононагинтиллион", "новемнонагинтиллион", ""};

    static String[] ending = {"а", "ов", "и"};
    static boolean working = true;
    static int count = 0;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (working) {
            System.out.println("Для выхода впишите: exit");
            try {
                System.out.println(result(bufferedReader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String result(String enter) {
        if (enter.length() > 312)
            return "Выключите пожалуйста залипание клавиш и попробуйте снова.";
        if (enter.equals("exit")) working = false;
        try {
            count = 0;
            StringBuilder result = new StringBuilder();

            for (int i = enter.length(); i >= 0; i -= 3) {
                if (i >= 3) {
                    result.insert(0, addDegreeNames(enter.substring(i - 3, i)));
                    result.insert(0, numbersToString(enter.substring(i - 3, i)) + " ");
                    count++;
                }
            }
            if (enter.length() % 3 == 1.0) {
                result.insert(0, addDegreeNames(enter.substring(0, 1)));
                result.insert(0, numbersToString(enter.substring(0, 1)) + " ");
            } else if (enter.length() % 3 == 2.0) {
                result.insert(0, addDegreeNames(enter.substring(0, 2)));
                result.insert(0, numbersToString(enter.substring(0, 2)) + " ");
            }
            removeWhiteSpaces(result);
            return result.toString();
        } catch (NumberFormatException e) {
            return "в переданной строке находятся буквенные значения, пожалуйста отредактируйте ваш запрос.";
        }
    }

    public static String numbersToString(String enter) {
        if (enter.charAt(0) == '0') {
            enter = enter.substring(1, 3);
        }
        if (Integer.parseInt(enter) == 0) return "";
        if (Integer.parseInt(enter) < 20) {
            return dig1[Integer.parseInt(enter)];
        } else if (Integer.parseInt(enter) < 100) {
            String one = enter.substring(0, 1);
            String two = enter.substring(1);
            if (two.equals("0")) {
                two = "22";
            }
            return dig20[Integer.parseInt(one) - 2] + " " + dig1[Integer.parseInt(two)];
        } else if (Integer.parseInt(enter) < 1000) {
            String one = enter.substring(0, 1);
            String two = enter.substring(1, 2);
            String three = enter.substring(2, 3);
            if (Integer.parseInt(enter.substring(1, 2)) + Integer.parseInt(enter.substring(2, 3)) < 20 && (two.equals("1") || two.equals("0"))) {
                three = enter.substring(1);
                if (three.equals("00")) {
                    return dig100[Integer.parseInt(one) - 1];
                }
                return dig100[Integer.parseInt(one) - 1] + " " + dig1[Integer.parseInt(three)];
            }
            if (two.equals("0")) {
                two = "10";
            }
            if (three.equals("0")) {
                three = "22";
            }
            return dig100[Integer.parseInt(one) - 1] + " " + dig20[Integer.parseInt(two) - 2] + " " + dig1[Integer.parseInt(three)];
        }
        return "ошибка преобразования в число";
    }

    public static String addDegreeNames(String enter) {
        int lastDigit = Integer.parseInt(enter);//12 6
        if (count == 0 || lastDigit == 0) {
            return "";
        } else if (count == 1) {
            if (lastDigit == 1) {
                return digStandart[count - 1] + ending[0] + " ";
            } else if (lastDigit < 5) {
                return digStandart[count - 1] + ending[2] + " ";
            } else if (count == 1 && Integer.parseInt(enter.substring(enter.length() - 1)) < 5) {
                return digStandart[count - 1] + ending[2] + " ";
            } else {
                return digStandart[count - 1] + " ";
            }
        } else if (lastDigit == 1)
            return digStandart[count - 1] + " ";
        else if (lastDigit < 5) {
            return digStandart[count - 1] + ending[1] + " ";
        } else return digStandart[count - 1] + ending[1] + " ";

    }

    static void removeWhiteSpaces(StringBuilder sb) {
        int end = 0;
        int spaceIndex = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i))) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = -1;
            } else if (spaceIndex < 0) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = i;
            }
        }
        sb.setLength(end);
    }
}
