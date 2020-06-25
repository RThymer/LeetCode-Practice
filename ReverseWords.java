public class ReverseWords {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        if (split.length == 1) return split[0];

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i > 0; --i) {
            sb.append(split[i] + " ");
        }
        sb.append(split[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("  the    blue    sky   is   a  "));
    }
}
