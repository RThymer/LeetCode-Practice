public class Count_Say {
    public String countAndSay(int n) {
        int num = 0, numCnt = 0;
        String init = "1";

        while (n-- > 1) {
            char[] chars = init.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < chars.length; ) {
                numCnt = 0;
                char charTmp = chars[index];
                while (index < chars.length && chars[index] == charTmp) {
                    numCnt++;
                    index++;
                }
                sb.append(numCnt + "" + charTmp);
            }
            init = sb.toString();
        }

        return init;
    }
}

class Count_SayTest {
    public static void main(String[] args) {
        System.out.println(new Count_Say().countAndSay(4));
    }
}