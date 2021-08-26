public class StringUtil {
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
