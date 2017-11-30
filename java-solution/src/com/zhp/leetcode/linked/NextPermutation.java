package com.zhp.leetcode.linked;

import java.util.Arrays;

/**
 * @author zhp.dts
 * @date 2017/11/30.
 */
public class NextPermutation {
    /* 1,3,2 -> 2,1,3*/
    public static void solution(int[] nums){
        if(nums.length>1){
            for(int i=nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    //更换
                    for(int j=nums.length-1;j>i+1;j--){
                        if(nums[j]>nums[i]&&nums[j]!=nums[i+1]){
                            int maxNum = nums[j];
                            nums[j] = nums[i];
                            nums[i] = maxNum;
                            Arrays.sort(nums,i+1,nums.length);
                            return;
                        }
                    }
                    int maxNum = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = maxNum;
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,4,3,3,1};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
