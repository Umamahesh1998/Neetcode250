package org.ps2.prefixsum;

/**
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
 * Each product is guaranteed to fit in a 32-bit integer.
 * Follow-up: Could you solve it in O(n) time without using the division operation?
 * Example 1:
 * Input: nums = [1,2,4,6]
 * Output: [48,24,12,8]
 */
public class ProductOfArrayExceptSelf_238 {
    /**
     * prefix product and suffix product calulate cheyali
     * we will create one array to store answer int[] ans=new int[n]
     * assign ans[0]=1
     * run a loop from i=1->i<n
     * append prefix multiplication to current index ans[i]=ans[i-1]*nums[i-1]
     * create suffix variable suffix=1 --> because we i=n-1 --> last element of array so we are using 1 for multiplication
     * run loop from i=n-1 --> i>=0
     * ans[i]*=suffix --> current ans element*suffix
     * suffix*=nums[i] --> update suffix value by multiplying it with nums[i]
     * return ans
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //calculate the prefix product
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return  ans;
    }
}
