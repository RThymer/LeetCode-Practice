public class Strstr {
    public static void main(String[] args) {
        System.out.println(strStr("def", "e"));

    }

    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int loopI = i, j = 0, matched = 0;
                while (loopI < haystack.length() && j < needle.length()) {
                    if (haystack.charAt(loopI) != needle.charAt(j)) {
                        matched = 0;
                        break;
                    }
                    matched = 1;
                    loopI += 1;
                    j++;
                }
                if (j == needle.length() && matched == 1) return i;
            }
        }
        return -1;

    }
}
