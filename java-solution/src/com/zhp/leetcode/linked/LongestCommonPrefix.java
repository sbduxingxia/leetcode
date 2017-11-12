package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/10.
 */
public class LongestCommonPrefix {
    public static String solution(String[] strs){
        if(strs.length==0){
            return "";
        }
        int maxIndex = -1;
        boolean isEqual =true;
        while(isEqual){
            maxIndex++;
            for(int i = 0;i<strs.length;i++){
                if(!isEqual||maxIndex>=strs[i].length()||strs[i].length()==0){
                    return strs[0].substring(0,maxIndex);
                }else{
                    if(i>0){
                        if(strs[i-1].charAt(maxIndex)!=strs[i].charAt(maxIndex)){
                            isEqual = false;
                            break;
                        }
                    }
                }
            }
        }
        return strs[0].substring(0,maxIndex);
    }
    public static void main(String[] args){
        System.out.println(solution(new String[]{"aabbcc","aabbccdd","aabbddee","aacde","aabcdedfg"}));
        System.out.println(solution(new String[]{"aabbcc","a","","aacde","aabcdedfg"}));
        System.out.println(solution(new String[]{"aabbcc","adbbccdd","aabbddee","aacde","aabcdedfg"}));
        System.out.println(solution(new String[]{"aaaaa"}));
    }
}
