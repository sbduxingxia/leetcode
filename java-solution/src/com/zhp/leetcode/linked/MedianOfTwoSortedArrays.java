package com.zhp.leetcode.linked;


/**
 * @author zhp.dts
 * @date 2017/11/2.
 * @info 两个有序数组取其所有数的中位数
 */
public class MedianOfTwoSortedArrays {
    public static double solution(int[] nums1, int [] nums2){
        int allNum = nums1.length+nums2.length;
        int forNum = allNum/2+1;
        int [] result = new int[2];
        int nums1Index = 0,nums2Index = 0;
        for(int i=0;i<forNum;i++){
            if(nums1Index>=nums1.length){
                result[i%2] = nums2[nums2Index];
                nums2Index++;
            }else if(nums2Index>=nums2.length){
                result[i%2] = nums1[nums1Index];
                nums1Index++;
            }else if(nums1[nums1Index]<nums2[nums2Index]){
                result[i%2] = nums1[nums1Index];
                nums1Index++;
            }else{
                result[i%2] = nums2[nums2Index];
                nums2Index++;
            }
        }
        if(allNum%2==1){
            return (double)(result[0]>result[1]?result[0]:result[1]);
        }else{
            return (double)(result[0]+result[1])/2;
        }
    }
    public static double solution2(int[] nums1, int [] nums2){
        int allNum = nums1.length+nums2.length;
        int forNum = allNum/2+1;
        int [] sortResult = new int[forNum];
        int nums1Index = 0,nums2Index = 0;
        for(int i=0;i<forNum;i++){
            if(nums1Index>=nums1.length){
                sortResult[i] = nums2[nums2Index];
                nums2Index++;
            }else if(nums2Index>=nums2.length){
                sortResult[i] = nums1[nums1Index];
                nums1Index++;
            }else if(nums1[nums1Index]<nums2[nums2Index]){
                sortResult[i] = nums1[nums1Index];
                nums1Index++;
            }else{
                sortResult[i] = nums2[nums2Index];
                nums2Index++;
            }
        }
        if(allNum%2==0){//偶数个
            return (double)(sortResult[forNum-1]+sortResult[forNum-2])/2;
        }else{
            return (double)sortResult[forNum-1];
        }
    }
    public static void main(String[] args){
        int[] nums1 =new int[]{1,2,3,23,24,25,45,67,89};
        int[] nums2 = new int[]{1,13,22,27,30,37,38,46,49,50,61,89,100};
        long startTime = System.nanoTime();
        System.out.println(solution2(nums1,nums2));
        System.out.println(System.nanoTime()-startTime);

    }
}
