public class Service {
    private int count;

    public String TranslateNumbersToString(String enter) {
        if (enter.startsWith("0")) return "Ноль ";
        if (enter.length() > 312) return "Выключите пожалуйста залипание клавиш и попробуйте снова.";
        try {
            count = 0;
            StringBuilder result = new StringBuilder();
            int countBitness = 3;
            for (int i = enter.length(); i >= 0; i -= countBitness) {
                if (i >= countBitness) {
                    String lastThreeDigit = enter.substring(i - countBitness, i);
                    result.insert(0, addDegreeNames(lastThreeDigit));
                    result.insert(0, numbersToString(lastThreeDigit) + " ");
                    count++;
                }
            }
            if (enter.length() % countBitness == 1.0) {
                result.insert(0, addDegreeNames(enter.substring(0, 1)));
                result.insert(0, numbersToString(enter.substring(0, 1)) + " ");
            } else if (enter.length() % countBitness == 2.0) {
                result.insert(0, addDegreeNames(enter.substring(0, 2)));
                result.insert(0, numbersToString(enter.substring(0, 2)) + " ");
            }
            StringUtil.removeWhiteSpaces(result);
            return result.toString();
        } catch (NumberFormatException e) {
            return "в переданной строке находятся буквенные значения, пожалуйста отредактируйте ваш запрос.";
        }
    }
    public String numbersToString(String enter) {
        if (enter.charAt(0) == '0') {
            enter = enter.substring(1, 3);
        }
        if (Integer.parseInt(enter) == 0) { return ""; }
        if (Integer.parseInt(enter) < 20) {
            if (count == 1 && enter.equals("1")) return Main.dig1[20];
            if (count == 1 && enter.equals("2")) return Main.dig1[21];
            return Main.dig1[Integer.parseInt(enter)];
        } else if (Integer.parseInt(enter) < 100) {
            String one = enter.substring(0, 1);
            String two = enter.substring(1);
            if (two.equals("1") && count == 1) {
                two = "20";
            }
            if (two.equals("2") && count == 1) {
                two = "21";
            }
            if (two.equals("0"))               {
                two = "22";
            }
            return Main.dig20[Integer.parseInt(one) - 2] + " " + Main.dig1[Integer.parseInt(two)];
        } else  {
            String firstNumber = enter.substring(0, 1);
            String secondNumber = enter.substring(1, 2);
            String thirdNumber = enter.substring(2, 3);
            if (Integer.parseInt(secondNumber) + Integer.parseInt(thirdNumber) < 20 && (secondNumber.equals("1") || secondNumber.equals("0"))) {
                thirdNumber = enter.substring(1);
                if (thirdNumber.equals("00")){
                    return Main.dig100[Integer.parseInt(firstNumber) - 1];
                }
                return Main.dig100[Integer.parseInt(firstNumber) - 1] + " " + Main.dig1[Integer.parseInt(thirdNumber)];
            }
            if (secondNumber.equals("0")) {
                secondNumber = "10";
            }
            if (thirdNumber.equals("0")) {
                thirdNumber = "22";
            }
            return Main.dig100[Integer.parseInt(firstNumber) - 1] + " " + Main.dig20[Integer.parseInt(secondNumber) - 2] + " " + Main.dig1[Integer.parseInt(thirdNumber)];
        }
    }
    public String addDegreeNames(String enter) {
        int parseAllEnter = Integer.parseInt(enter);
        int lastDigit = Integer.parseInt(enter.substring(enter.length() - 1));
        int index = count-1;
        if (count == 0 || parseAllEnter == 0) {
            return "";
        }
        else if (count == 1) {
            if (lastDigit == 1 && !enter.contains("11")) {
                return Main.digStandart[index] + Main.ending[0] + " ";
            }
            else if (parseAllEnter < 5 && !enter.equals("11") && !enter.equals("12") && !enter.equals("13") && !enter.equals("14"))
                return Main.digStandart[index] + Main.ending[2] + " ";
            else{
                return Main.digStandart[index] + " ";
            }
        } else if (lastDigit == 1)  {
            return Main.digStandart[index] + " ";
        }
        else    {
            return Main.digStandart[index] + Main.ending[1] + " ";
        }
    }
}
