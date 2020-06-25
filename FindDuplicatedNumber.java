public class FindDuplicatedNumber {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            int midCnt = 0;
            for (int i : nums) {
                if (i <= mid) midCnt++;
            }
            if (midCnt > mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    //找不同的i和j，使nums[i]==nums[j]:
    //与检测循环链表入口结点的方法一样
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; //走两次
        } while (nums[slow] != nums[fast]);
        //此时slow和fast相遇
        int restart = 0;
        while (nums[restart] != nums[slow]) { //寻找入环节点
            restart = nums[restart];
            slow = nums[slow];
        }
        return nums[restart];
    }
}
