public class LongestPalindrome_2 {
    public static String longestPalindrome(String s) {
        int evenMax = 0, oddMax = 0;
        int evenIndex = 0, oddIndex = 0;
        int leftPos = 0, rightPos = 0;
        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while(((left >= 0)&&(right < s.length()))&&(s.charAt(left) == s.charAt(right))){
                left--;
                right++;
            }
            if((right - left + 1 - 2) > evenMax) {
                evenMax = right - left + 1 - 2;
                evenIndex = i;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i + 1;
            while((s.charAt(left) == s.charAt(right))&&((left >= 0)&&(right < s.length()))) {
                left--;
                right++;
            }
            if((right - left + 1 - 2) > oddMax) {
                oddMax = right - left + 1 - 2;
                oddIndex = i;
            }
        }

        if(evenMax < oddMax) {
            leftPos = oddIndex - (oddMax / 2) + 1;
            rightPos = oddIndex + oddMax / 2 + 1;
        }
        else
        {
            leftPos = evenIndex - (evenMax / 2);
            rightPos = evenIndex + evenMax / 2 + 1;
        }

        return s.substring(leftPos,rightPos);
    }

    public static void main(String[] args) {
        String testString = "babad";
        System.out.println(longestPalindrome(testString));
    }
}
