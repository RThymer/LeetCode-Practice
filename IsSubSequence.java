public class IsSubSequence {

    // 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    public boolean isSubsequence(String s, String t) {
        int tIter = 0, sIter = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        while (tIter < t.length() && sIter < s.length()) {
            if (tArray[tIter] == sArray[sIter]) {
                ++tIter;
                ++sIter;
            } else {
                tIter++;
            }
        }
        return sIter == s.length();
    }

    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        System.out.println(isSubSequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubSequence.isSubsequence("axc", "ahbgdc"));
    }
}
