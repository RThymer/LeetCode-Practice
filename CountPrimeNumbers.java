import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPrimeNumbers {
    //Count the number of primes less than the input n;
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int numOfPrimes = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i < n; ++i){
            if(isPrime[i]){
                for(int j = 2 * i; j < n; j += i) isPrime[j] = false;
            }
        }

        for(boolean i : isPrime){
            numOfPrimes = i ? numOfPrimes + 1 : numOfPrimes;
        }

        return numOfPrimes;
    }

    public static void main(String[] args){
        System.out.println(new CountPrimeNumbers().countPrimes(0));
        String s = "";
        System.out.println(s.length());
    }
}
