import java.util.ArrayList;
import java.util.List;

public class PhoneLetter {
    public List<String> letterCombinations(String digits) {
        String[] digitChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        List<Character> recruitPath = new ArrayList<>();
        if (digits.length() == 0) return new ArrayList<String>(0) {
        };
        recruitCombination(digitChars, digits, 0, result, recruitPath);
        return result;
    }

    private void recruitCombination(String[] digitChars, String digits,
                                    int index, List<String> result, List<Character> recruitPath) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char i : recruitPath) sb.append(i);
            result.add(sb.toString());
            return;
        }
        String getDigits = digitChars[digits.charAt(index) - '0'];
        int charsLength = getDigits.length();
        for (int i = 0; i < charsLength; i++) {
            recruitPath.add(getDigits.charAt(i));
            recruitCombination(digitChars, digits, index + 1, result, recruitPath);
            recruitPath.remove(recruitPath.size() - 1);
        }
    }
}

class PhoneLetterTest {
    public static void main(String[] args) {
        System.out.println(new PhoneLetter().letterCombinations("34"));
    }
}
