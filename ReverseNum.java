public class ReverseNum {
    public static boolean isPalindrome(int x) {
        int reverse = 0;
        if(x < 0) return false;
        do{
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }while(x != 0);

        if(x != reverse) return false;
        else return true;
    }
    public static void main(String[] args) {
        int test = 121;
        System.out.println(isPalindrome(test));
    }
}
