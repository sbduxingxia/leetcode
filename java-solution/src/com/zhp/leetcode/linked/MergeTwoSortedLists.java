package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

/**
 * @author zhp.dts
 * @date 2017/11/15.
 * @info merge两个有序数列
 */
public class MergeTwoSortedLists {
    public static ListNode solution(ListNode l1,ListNode l2){
        ListNode resultNode = null;

        if(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    resultNode = l1;
                    l1 = l1.next;
                }else{
                    resultNode = l2;
                    l2 = l2.next;
                }
            }else if(l1==null){
                return l2;
            }else/* if(l2==null)*/{
                return l1;
            }
        }else{
            return null;
        }
        ListNode cacheResult  = resultNode;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    cacheResult.next = l1;
                    l1 = l1.next;
                    cacheResult = cacheResult.next;
                }else{
                    cacheResult.next = l2;
                    l2 = l2.next;
                    cacheResult = cacheResult.next;
                }
            }else if(l1==null){
                cacheResult.next = l2;
                break;
            }else{
                cacheResult.next = l1;
                break;
            }
        }
        return resultNode;
    }
    public static void main(String[] args){
        ListNode listNode = new ListNode(2);
        ListNode cacheNode = listNode;
        for(int i=0;i<5;i++){
            cacheNode.next = new ListNode(2*i+3);
            cacheNode = cacheNode.next;
        }
        ListNode listNode2 = new ListNode(0);
        cacheNode = listNode2;
        for(int i=0;i<5;i++){
            cacheNode.next = new ListNode(3*i+1);
            cacheNode = cacheNode.next;
        }

        ListNode resutNode = solution(listNode,listNode2);
        while(resutNode!=null){
            System.out.print(resutNode.val+"->");
            resutNode = resutNode.next;
        }

    }
}
