import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class _414ThirdBiggestNum {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }

    public static int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;

        for (Integer num : nums) {
            if (num.equals(first) || num.equals(second) || num.equals(third)) {
                continue;
            }
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        return third == null ? first : third;
    }
}
