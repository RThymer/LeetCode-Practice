import java.util.Objects;

/**
 * @author thinair
 * 将两个字符串形式的数字相加
 *
 * 提示：
 *
 * num1 和num2的长度都小于 5100
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _415AddStrings {

    public String addStrings(String num1, String num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return null;
        }

        int lenNum1 = num1.length();
        int lenNum2 = num2.length();
        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;
        while (lenNum1 > 0 && lenNum2 > 0) {
            int dig1 = num1.charAt(lenNum1 - 1) - '0';
            int dig2 = num2.charAt(lenNum2 - 1) - '0';
            int curSum = dig1 + dig2 + carry;
            carry = curSum / 10;
            int left = curSum % 10;
            stringBuilder.append(left);
            lenNum1--;
            lenNum2--;
        }

        while (lenNum1 > 0) {
            int dig1 = num1.charAt(lenNum1 - 1) - '0';
            int curSum = dig1 + carry;
            carry = curSum / 10;
            int left = curSum % 10;
            stringBuilder.append(left);
            lenNum1--;
        }

        while (lenNum2 > 0) {
            int dig2 = num2.charAt(lenNum2 - 1) - '0';
            int curSum = dig2 + carry;
            carry = curSum / 10;
            int left = curSum % 10;
            stringBuilder.append(left);
            lenNum2--;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _415AddStrings().addStrings("1", "2"));
        System.out.println(new _415AddStrings().addStrings("1", "22"));
        System.out.println(new _415AddStrings().addStrings("1", "222"));
        System.out.println(new _415AddStrings().addStrings("122", "2"));
        System.out.println(new _415AddStrings().addStrings("1233333344363257347245745384572474782452", "2484675474574574575474574575474"));

    }
}
