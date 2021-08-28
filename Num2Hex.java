public class Num2Hex {
    private static String toHexDigit(int num) {
        if (num < 10) {
            return String.valueOf(num);
        }

        switch (num) {
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
            default:
                return "";
        }
    }

    private static String toHex(int num) {
        // 每次取最后四位 四位一组 算十六进制
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int mask = 15;
            int group = (num >> (i * 4)) & mask;
            String curHexDigit = toHexDigit(group);
            if (stringBuilder.length() == 0 && curHexDigit.equals("0")) {
                continue;
            }
            stringBuilder.append(curHexDigit);
        }

        return num == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(15));
        System.out.println(toHex(16));
        System.out.println(toHex(-1));
        System.out.println(toHex(0));
    }
}
