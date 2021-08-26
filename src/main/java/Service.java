public class Service {
    int count;

    public String result(String enter) {
        if (enter.startsWith("0")) return "Ноль ";
        if (enter.length() > 312) return "Выключите пожалуйста залипание клавиш и попробуйте снова.";
        if (enter.equals("exit")) Main.working = false;
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
            ResultStringFormat.removeWhiteSpaces(result);///////////////
            return result.toString();
        } catch (NumberFormatException e) {
            return "в переданной строке находятся буквенные значения, пожалуйста отредактируйте ваш запрос.";
        }
    }


    public String numbersToString(String enter) {
        if (enter.charAt(0) == '0') enter = enter.substring(1, 3);

        if (Integer.parseInt(enter) == 0) return "";
        if (Integer.parseInt(enter) < 20) {
            if (count == 1 && enter.equals("1")) return Main.dig1[20];
            if (count == 1 && enter.equals("2")) return Main.dig1[21];
            return Main.dig1[Integer.parseInt(enter)];
        } else if (Integer.parseInt(enter) < 100) {
            String one = enter.substring(0, 1);
            String two = enter.substring(1);
            if (two.equals("1") && count == 1) two = "20";
            if (two.equals("2") && count == 1) two = "21";
            if (two.equals("0"))               two = "22";
            return Main.dig20[Integer.parseInt(one) - 2] + " " + Main.dig1[Integer.parseInt(two)];
        } else  {
            String one = enter.substring(0, 1);
            String two = enter.substring(1, 2);
            String three = enter.substring(2, 3);
            if (Integer.parseInt(two) + Integer.parseInt(three) < 20 && (two.equals("1") || two.equals("0"))) {
                three = enter.substring(1);
                if (three.equals("00")) return Main.dig100[Integer.parseInt(one) - 1];
                return Main.dig100[Integer.parseInt(one) - 1] + " " + Main.dig1[Integer.parseInt(three)];
            }
            if (two.equals("0")) two = "10";
            if (three.equals("0")) three = "22";

            return Main.dig100[Integer.parseInt(one) - 1] + " " + Main.dig20[Integer.parseInt(two) - 2] + " " + Main.dig1[Integer.parseInt(three)];
        }
    }

    public String addDegreeNames(String enter) {
        String enterOld = enter;
        enter = enter.substring(enter.length() - 1);
        int lastDigit1 = Integer.parseInt(enterOld);
        int lastDigit = Integer.parseInt(enter);
        if (count == 0 || lastDigit1 == 0) return "";
        else if (count == 1) {
            if (lastDigit == 1 && !enterOld.contains("11")) return Main.digStandart[count - 1] + Main.ending[0] + " ";
            else if (lastDigit1 < 5 && !enterOld.equals("11") && !enterOld.equals("12") && !enterOld.equals("13") && !enterOld.equals("14"))
                return Main.digStandart[count - 1] + Main.ending[2] + " ";
            else                                            return Main.digStandart[count - 1] + " ";
        } else if (lastDigit == 1)  return Main.digStandart[count - 1] + " ";
        else if (lastDigit < 5)   return Main.digStandart[count - 1] + Main.ending[1] + " ";
        else                      return Main.digStandart[count - 1] + Main.ending[1] + " ";
    }
}
