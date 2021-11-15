public class _1137Nth_Tribonacci_Number {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for (int index = 3; index < n + 1; index++) {
            array[index] = array[index - 1] + array[index - 2] + array[index - 3];
        }

        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(new _1137Nth_Tribonacci_Number().tribonacci(1));
        System.out.println(new _1137Nth_Tribonacci_Number().tribonacci(4));
        System.out.println(new _1137Nth_Tribonacci_Number().tribonacci(25));
    }
}
