public class LastWordLength {
    public int lengthOfLastWord(String s) {
        int length = 0;

        String[] result = s.trim().split(" ");


        return result[result.length - 1].length();
    }
}

class LastWordLengthTest{
    public static void main(String[] args) {
        System.out.println(new LastWordLength().lengthOfLastWord("   afd     b  "));
    }
}
