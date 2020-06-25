public class AddBinary {
    public String addBinary(String a, String b) {
        int aPos = a.length() - 1, bPos = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (aPos >= 0 && bPos >= 0) {
            int aL = a.charAt(aPos) - '0';
            int bL = b.charAt(bPos) - '0';

            int bitSum = aL + bL + carry;
            if (bitSum > 1) {
                bitSum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            aPos--;
            bPos--;
            sb.append(bitSum);
        }
        while (aPos >= 0) {
            int aL = a.charAt(aPos) - '0';

            int bitSum = aL + carry;
            if (bitSum > 1) {
                bitSum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            aPos--;
            sb.append(bitSum);
        }
        while (bPos >= 0) {
            int bL = b.charAt(bPos) - '0';

            int bitSum = bL + carry;
            if (bitSum > 1) {
                bitSum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            bPos--;
            sb.append(bitSum);
        }
        if (carry == 1) {

            StringBuilder sb1 = new StringBuilder();
            sb1.append(1);
            sb1.append(new StringBuilder(sb.toString()).reverse().toString());
            return sb1.toString();
        }
        return new StringBuilder(sb.toString()).reverse().toString();
    }
}

class AddBinaryTest {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("101", "100"));
    }
}
