package problem;

/**
 * Created by lhm on 2020/3/23.
 */
public class MaxSubArray {

    //Runtime: 2 ms, faster than 13.42% of Java online submissions for Maximum Subarray.
    //Memory Usage: 42.1 MB, less than 5.16% of Java online submissions for Maximum Subarray.
    public int maxSubArray1(int[] nums) {
        return Subarray(nums, 0, nums.length - 1);
    }

    public int Subarray(int[] A, int left, int right) {
        if (left == right) {
            return A[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = Subarray(A, left, mid);// left part
        int rightSum = Subarray(A, mid + 1, right);//right part
        int crossSum = crossSubarray(A, left, right);// cross part
        if (leftSum >= rightSum && leftSum >= crossSum) {// left part is max
            return leftSum;
        }
        if (rightSum >= leftSum && rightSum >= crossSum) {// right part is max
            return rightSum;
        }
        return crossSum; // cross part is max
    }

    public int crossSubarray(int[] A, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for (int i = mid; i >= left; i--) {
            sum = sum + A[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum = sum + A[j];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }


    //Runtime: 1 ms, faster than 88.04% of Java online submissions for Maximum Subarray.
    //Memory Usage: 41.5 MB, less than 5.16% of Java online submissions for Maximum Subarray.
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp[i] can be nums[i] or dp[i-1] + nums[i], depends on which is larger
            // dp[i] will keep max at i
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
    //Memory Usage: 41.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
    public int maxSubArray3(int[] nums) {
        int tmp = 0;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {// for sum less than 0
            if (nums[i] > ans) ans = nums[i];
        }
        if (ans <= 0 || nums.length == 1) return ans;

        for (int i = 0; i < nums.length; i++) {//for largest sum greater than 0
            tmp += nums[i];
            if (tmp <= 0) {
                tmp = 0;
                continue;
            } else {
                if (tmp > ans) ans = tmp;
            }
        }
        return ans;
    }

}
