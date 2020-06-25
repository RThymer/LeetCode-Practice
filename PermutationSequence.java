import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {

        int[] perms = new int[n];
        perms[0] = 1;
        for (int i = 1; i < n; i++) perms[i] = (i + 1) * perms[i - 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i + 1);

        StringBuilder sb = new StringBuilder();

        k--;
        for (int i = 0; i < n - 1; i++) {
            int permPos = i, perm = perms[n - permPos - 1 - 1];
            int pos = k / perm;
            sb.append(list.get(pos));
            list.remove(pos);
            k = k % perm;
        }
        sb.append(list.get(0));


        return sb.toString();
    }
}

class PermutationSequenceTest {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3));
    }
}