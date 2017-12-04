package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/12/4.
 * @info 在有序循环数组中找到target返回其索引位置值，否则返回-1；默认没有重复的数值
 */
public class SearchInRotatedSortedArray {
    public static int solution(int[] nums,int target){
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{4,5,6,7,0,1,2,8,9,10},8));
    }
}
