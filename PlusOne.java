import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

class PlusOneTest{
    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9,9,9});
    }
}