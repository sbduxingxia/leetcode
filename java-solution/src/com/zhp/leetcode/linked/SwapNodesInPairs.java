package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

/**
 * @author zhp.dts
 * @date 2017/11/17.
 */
public class SwapNodesInPairs {
    public static ListNode solution(ListNode head){
        int i=0;
        ListNode nodeCache = head;
        ListNode resultNode = new ListNode(0);
        resultNode.next = head;
        ListNode preNode = resultNode;
        ListNode curFirst = head;
        while(nodeCache!=null){
            if(i%2==0){
                curFirst = nodeCache;
                nodeCache = nodeCache.next;
            }else{
                preNode.next = nodeCache;
                curFirst.next = nodeCache.next;
                nodeCache.next = curFirst;
                preNode = curFirst;
                nodeCache = curFirst.next;
            }
            i++;
        }
        return resultNode.next;
    }
    public static void main(String[] args){
        ListNode listNode = new ListNode(0);
        ListNode cacheNode = listNode;
        for(int i=0;i<6;i++){
            cacheNode.next = new ListNode(i+1);
            cacheNode = cacheNode.next;
        }
        ListNode resutNode = solution(listNode);
        while(resutNode!=null){
            System.out.print(resutNode.val+"->");
            resutNode = resutNode.next;
        }
    }
}
