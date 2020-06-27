public class GetSumWithoutNumOperator {

    public int getSumRecursive(int a, int b) {
        // 异或运算，不同时结果为1，计算结果为非进位和
        int sumWithoutCarry = a ^ b;
        // 与运算，同为1时结果为1，计算结果为进位
        int carry = (a & b) << 1;

        if (carry == 0) {
            return sumWithoutCarry;
        }

        return getSumRecursive(sumWithoutCarry, carry);
    }

    public int getSumBitByBit(int a, int b) {
        int sum = 0, carry = 0, curPos = 1;
        // curPos一直左移最后溢出后为0
        while (curPos != 0) {
            int curBitA = a & curPos;
            int curBitB = b & curPos;

            if (carry == 1) {
                if (curBitA != 0 || curBitB != 0) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum = sum ^ curBitA ^ curBitB ^ curPos;
            } else {
                if (curBitA != 0 && curBitB != 0) {
                    carry = 1;
                } else {
                    carry = 0;
                    sum = sum ^ curBitA ^ curBitB;
                }
            }
            curPos = curPos << 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        GetSumWithoutNumOperator getSumWithoutNumOperator = new GetSumWithoutNumOperator();
        System.out.println(getSumWithoutNumOperator.getSumBitByBit(1100017, -15));
        System.out.println(Integer.MIN_VALUE + Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
    }

}
