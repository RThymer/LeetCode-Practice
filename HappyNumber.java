import java.util.Set;
import java.util.TreeSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        boolean isHappy = false;
        Set<Integer> set = new TreeSet<>();
        while(!set.contains(n)){
            set.add(n);
            n = calcHappy(n);
            if(n == 1) isHappy = true;
        }
        return isHappy;
    }
    private int calcHappy(int n){
        int sum = 0;
        while (n > 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
