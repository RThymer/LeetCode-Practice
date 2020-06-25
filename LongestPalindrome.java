public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLength = 0, maxIndex = 0, oddFlag = 0;
        StringBuffer resultString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int currentLength = 0;
            for (int j = 0; (j < s.length() - i) && (j <= i); j++) {
                if (s.charAt(i - j) == s.charAt(i + j))
                    currentLength = 2 * j + 1;
            }
            if (maxLength < currentLength) {
                maxLength = currentLength;
                maxIndex = i;
                if (currentLength % 2 == 0) oddFlag = 1;
                else oddFlag = 0;
            }
            for (int j = 0; (j < s.length() - i - 1) && (j <= i); j++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j))
                        currentLength = 2 * j + 2;
                }
            }
            if (maxLength < currentLength) {
                maxLength = currentLength;
                maxIndex = i;
                if (currentLength % 2 == 0) oddFlag = 1;
                else oddFlag = 0;
            }
        }
        if (oddFlag == 0)
            resultString.append(s, maxIndex - (maxLength - 1) / 2, maxIndex + (maxLength - 1) / 2 + 1);
        else resultString.append(s, maxIndex - (maxLength - 2) / 2, maxIndex + (maxLength - 2) / 2 + 2);
        return resultString.toString();
    }

    public static void main(String[] args) {
        String testString = "ccc";
        System.out.println(longestPalindrome(testString));
    }
}
