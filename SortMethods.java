import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMethods {

    public static void selectSort(int[] nums) {
        //选择出数组中最小的元素，将它与数组的第一个元素交换
        //
        for (int i = 0; i < nums.length; ++i) {
            int minPos = i; //每次循环的临时最小量。
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[minPos]) minPos = j;
            }
            swap(nums, minPos, i);
        }
    }

    public static void bubbleSort(int[] nums) {
        //从左到右不断交换逆序的元素对，每一轮循环过后，最大的元素变换到最右;
        for (int i = 1; i < nums.length - 1; ++i) {
            for (int j = 0; j < nums.length - i; ++j) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    public static void insertSort(int[] nums) {
        //每次都将当前元素插入到左侧已经排序的数组中，使插入之后左侧依然有序;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
            }
        }
    }

    public static void shellSort(int[] nums) {
        //对于大规模的数组，交换相邻元素的插入排序很慢
        //希尔排序使用插入排序对间隔h的序列排序，不断减小h至1即可使整个序列有序;
        int h = 1;
        while (h < (nums.length / 3)) h = 3 * h + 1; //计算最接近数组的h 1,4,13...

        while (h >= 1) {
            //插入排序，间隔不是1而是h
            for (int i = h; i < nums.length; ++i) { //从第二组的第一个开始
                for (int j = i; j > h - 1; j -= h) {
                    if (nums[j] < nums[j - h]) swap(nums, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void mergeSortRecursive(int[] nums) {
        //将数组不断向下切分， 直到数组元素只剩下一个，再进行合并
        mergeHelper(nums, 0, nums.length - 1);
    }

    private static void mergeHelper(int[] nums, int left, int right) {
        if (left >= right) return;
        else {
            int mid = (left + right) >> 1;
            mergeHelper(nums, left, mid);
            mergeHelper(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public static void mergeSortIteration(int[] nums) {
        //迭代，从小数组起归并
        for (int size = 1; size < nums.length; size *= 2) { //外层循环控制一趟归并的大小
            for (int pos = 0; pos < nums.length - size; pos += 2 * size) {
                merge(nums, pos, pos + size - 1,
                        Math.min(pos + 2 * size - 1, nums.length - 1));
            }
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        //把两个有序的数组合并成一个
        int leftIter = left; //left -> mid闭区间;
        int rightIter = mid + 1; //mid + 1 -> right闭区间

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) { //复制数据到临时数组
            tmp[i] = nums[i];
        }

        for (int i = left; i <= right; ++i) {
            if (leftIter > mid) {
                nums[i] = tmp[rightIter++];
            } else if (rightIter > right) {
                nums[i] = tmp[leftIter++];
            } else if (tmp[leftIter] > tmp[rightIter]) {
                nums[i] = tmp[rightIter++];
            } else {
                nums[i] = tmp[leftIter++];
            }
        }
    }

    public static void quickSort(Integer[] nums) {
        //快速排序使用一个元素将一个数组切分为两个子数组，
        //左边元素小于该元素，右边元素大于该数组
        //重复第二步直到
        //选择的基准数很有讲究，若选择第一个数同时该数组本身有序，复杂度为O(N×N)

        //为了防止数组本身有序，将数组打乱：
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);

        quickSortHelper(nums, 0, nums.length - 1);

    }

    private static void quickSortHelper(Integer[] nums, int left, int right) {
        if (left >= right) return;
        else {
            int sliceElement = partition(nums, left, right); //一趟快排后的切分元素
            //迭代直到只剩一个元素
            quickSortHelper(nums, left, sliceElement - 1);
            quickSortHelper(nums, sliceElement + 1, right);
        }
    }

    private static int partition(Integer[] nums, int left, int right) {
        int leftPos = left + 1, rightPos = right;//初始的左右位置
        int slice = nums[left]; //切分元素

        for (; ; ) {
            while (nums[leftPos] < slice && leftPos < right) leftPos++;
            while (nums[rightPos] > slice && rightPos > left) rightPos--;
            if (leftPos >= rightPos) break;
            else {
                swap(nums, leftPos, rightPos);
            }
        }
        //把数组头的切分元素换到数组中间，
        // 此时rightPos指向小于切分元素的值，自然将它调到前面去。
        swap(nums, left, rightPos);

        return rightPos;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5, 3, 4, 6, 18, 2, 0, 8};
        SortMethods.quickSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
