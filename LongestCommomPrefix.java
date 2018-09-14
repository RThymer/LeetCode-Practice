public class LongestCommomPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int validChar = 0;
        if(strs.length == 1) return strs[0];
        int minLength = Integer.MAX_VALUE;
        for(int m = 0; m < strs.length; m++)
            if(minLength > strs[m].length())
                minLength = strs[m].length();
        for(int i = 0; i < minLength; i++) {
            for(int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) == strs[j + 1].charAt(i)) validChar = 1;
                else {
                    validChar = 0;
                    break;
                }
            }
            if(validChar == 1) sb.append(strs[0].charAt(i));
            else break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testString = {"falex", "flexible", "fly"};
        System.out.println(longestCommonPrefix(testString));
    }
}
