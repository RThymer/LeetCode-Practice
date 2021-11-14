public class _509_Fibonacci {
    public int fib(int n) {
        int[] result = new int[n + 1];
        if (n < 2) {
            return n;
        }

        result[0] = 0;
        result[1] = 1;

        for (int index = 2; index < n + 1; ++index) {
            result[index] = result[index - 1] + result[index - 2];
        }

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new _509_Fibonacci().fib(1));
        System.out.println(new _509_Fibonacci().fib(2));
        System.out.println(new _509_Fibonacci().fib(3));
        System.out.println(new _509_Fibonacci().fib(4));
    }
}
