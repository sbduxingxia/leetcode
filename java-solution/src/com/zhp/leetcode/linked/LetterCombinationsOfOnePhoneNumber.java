package com.zhp.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2017/11/13.
 */
public class LetterCombinationsOfOnePhoneNumber {
    public static List<String> solution(String digits){
        if(digits==null||digits.length()==0) {
            return null;
        }
        String [] charts = {"a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int [][] nums = {
                {0,0},//0
                {0,0},//1
                {0,3},//2
                {3,3},//3
                {6,3},//4
                {9,3},//5
                {12,3},//6
                {15,4},//7
                {19,3},//8
                {22,4}//9

        };
        List<String> cacheList = new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            int index = digits.toLowerCase().charAt(i)-'0';
            if(i==0){
                for(int j=0;j<nums[index][1];j++){
                    String one = charts[nums[index][0]+j];
                    cacheList.add(one);
                }
            }else{
                List<String> cacheList2 = new ArrayList<String>();
                for(int j=0;j<cacheList.size();j++){
                    String oldStr = cacheList.get(j);
                    for(int k = 0;k<nums[index][1];k++){
                        String one = charts[nums[index][0]+k];
                        cacheList2.add(oldStr+one);
                    }
                }
                cacheList.clear();
                cacheList.addAll(cacheList2);
            }
        }
        return cacheList;
    }
    public static List<String> solution2(String digits){
        if(digits==null||digits.length()==0) {
            return null;
        }
        String [] charts = {"a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int [][] nums = {
                {0,0},//0
                {0,0},//1
                {0,3},//2
                {3,3},//3
                {6,3},//4
                {9,3},//5
                {12,3},//6
                {15,4},//7
                {19,3},//8
                {22,4}//9

        };
        List<String> cacheList = new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            int index = digits.toLowerCase().charAt(i)-'0';
            if(i==0){
                for(int j=0;j<nums[index][1];j++){
                    String one = charts[nums[index][0]+j];
                    cacheList.add(one);
                }
            }else{
                List<String> cacheList2 = new ArrayList<String>();
                for(int j=0;j<cacheList.size();j++){
                    String oldStr = cacheList.get(j);
                    for(int k = 0;k<nums[index][1];k++){
                        String one = charts[nums[index][0]+k];
                        cacheList2.add(oldStr+one);
                    }
                }
                cacheList.clear();
                cacheList.addAll(cacheList2);
            }
        }
        return cacheList;
    }
    public static void main(String[] args){
        for(String one : solution("23232323232323")){
            System.out.print(one+",");
        }
        System.out.println("");

    }
}
