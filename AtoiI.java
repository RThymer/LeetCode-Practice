
public class AtoiI {
    public static int myAtoi(String str) {
        String noSpace = str.trim();
        char[] charArray = noSpace.toCharArray();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int sign = 1;
        if (charArray.length == 0) return 0;
        if (charArray[0] == '-') {
            sb.append("-");
            sign = -1;
            if (charArray.length == 1) sign = 0;
        }
        if (charArray[0] == '+') {
            sb.append("+");
            sign = 1;
            if (charArray.length == 1) sign = 0;
        } else if ((charArray[0] > '9') || (charArray[0] < '0')) return 0;
        else sb.append(charArray[0]);

        for (int i = 1; (i < charArray.length) && (charArray[i] >= '0') && (charArray[i] <= '9'); i++) {
            sb.append(charArray[i]);
        }

        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (sign == 1) return Integer.MAX_VALUE;
            else if (sign == -1) return Integer.MIN_VALUE;
            else return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        String testString = "    -42";
        System.out.println(myAtoi(testString));
    }
}
