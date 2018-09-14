import java.util.Arrays;
import java.util.Stack;

public class NextPermutation {
        public void nextPermutation(int[] nums) {
            if(nums.length == 0 || nums.length == 1) return;
            boolean swapFlag = false;
            for(int i = nums.length - 2; i >= 0; i--)
                for(int j = nums.length - 1; j > i; j--){
                    if(nums[i] < nums[j]){
                        swap(nums, i, j);
                        Arrays.sort(nums, i + 1, nums.length);
                        swapFlag = true;
                        break;
                    }
                }

            if(!swapFlag) {
                for(int index = 0; index < nums.length / 2; index++)
                    swap(nums, index, nums.length - 1 - index);
            }
        }

        void swap(int[] nums, int index1, int index2) {
            if(index1 < 0 || index2 < 0 || index1 > nums.length -1 || index2 > nums.length -1 ) return;
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
}

class Test {
    public static void main(String[] args) {
        //int[] a = new int[]{1,2,3};
        //new NextPermutation().nextPermutation(a);
        //System.out.println(Arrays.toString(a));
        //Arrays.sort(a,0,3);
        //System.out.println(Arrays.toString(a));
        String a = "123";
        a.toCharArray();

    }
}
