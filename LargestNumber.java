import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];

        for(int i = 0; i < nums.length; ++i){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,C);

        if(strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);
        return sb.toString();
    }

    private Comparator<String> C =
            (String o1, String o2) -> (o2 + o1).compareTo(o1 + o2);


    public static void main(String[] args){
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
    }
}
