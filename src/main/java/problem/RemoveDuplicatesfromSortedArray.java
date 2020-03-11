package problem;

/**
 * Created by lhm on 2020/3/11.
 */
public class RemoveDuplicatesfromSortedArray {


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 41.7 MB, less than 15.43% of Java online submissions for Remove Duplicates from Sorted Array.
    public int removeDuplicates1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 41.3 MB, less than 21.81% of Java online submissions for Remove Duplicates from Sorted Array.
    public int removeDuplicates2(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
