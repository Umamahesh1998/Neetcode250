package org.ps1.prefixSum;

public class ProductOfArrayExceptSelf_238_prefix_suffix {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //calculate prefix
        //everything before the index
        ans[0] = 1;
        for (int i = 1; i < n - 1; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //multiply with suffix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            //update the ans with suffix value
            ans[i] *= suffix;
            //update suffix value
            suffix *= nums[i];
        }
        return ans;
    }
}
