package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2017/11/14.
 * @info 从后往前移除第n个链表数据
 */
public class RemoveNthNodeFromEndOfList {
    public static ListNode solution(ListNode head,int n){
        List<ListNode> cachePath = new ArrayList<>();
        ListNode cacheNode = head;
        while(cacheNode!=null){
            cachePath.add(cacheNode);
            cacheNode = cacheNode.next;
        }
        if(cachePath.size()-n>=0){
            if(cachePath.size()-n-1>=0){
                cachePath.get(cachePath.size()-n-1).next = cachePath.get(cachePath.size()-n).next;
                return head;
            }else{
                return cachePath.get(cachePath.size()-n).next;
            }
        }else{
            return null;
        }
    }
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        ListNode cacheNode = listNode;
        for(int i=0;i<5;i++){
            cacheNode.next = new ListNode(i+2);
            cacheNode = cacheNode.next;
        }
        ListNode result = solution(listNode,6);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.println("");
    }
}
