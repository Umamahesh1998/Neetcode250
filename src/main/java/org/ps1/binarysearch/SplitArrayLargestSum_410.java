package org.ps1.binarysearch;

public class SplitArrayLargestSum_410 {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }
        int ans=high;
        while (low<=high){
            int mid=low+(high-low)/2;
            int subArray=1;
            int currentSum=0;
            for (int n : nums) {
                if(currentSum+n>mid){
                    subArray++;
                    currentSum=n;
                }else{
                    currentSum+=n;
                }
            }
            if(subArray<=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
