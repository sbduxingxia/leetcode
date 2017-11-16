package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhp.dts
 * @date 2017/11/16.
 */
public class MergeManySortedLists {
    public ListNode solution(ListNode[] lists){
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2)
            {
                return n1.val-n2.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            ListNode node = lists[i];
            if(node!=null)
            {
                heap.offer(node);
            }
        }
        ListNode resultNode = new ListNode(0);
        ListNode cacheNode = resultNode;
        while(heap.size()>0){
            cacheNode.next = heap.poll();
            cacheNode = cacheNode.next;
            if(cacheNode.next!=null){
                heap.offer(cacheNode.next);
            }
        }
        return resultNode.next;
    }
    public static void main(String[]args){
        MergeManySortedLists mergeManySortedLists = new MergeManySortedLists();
        ListNode listNode = new ListNode(2);
        ListNode cacheNode = listNode;
        for(int i=0;i<5;i++){
            cacheNode.next = new ListNode(2*i+3);
            cacheNode = cacheNode.next;
        }
        ListNode listNode2 = new ListNode(0);
        cacheNode = listNode2;
        for(int i=0;i<6;i++){
            cacheNode.next = new ListNode(3*i+1);
            cacheNode = cacheNode.next;
        }

        ListNode resutNode = mergeManySortedLists.solution(new ListNode[]{listNode,listNode2});
        while(resutNode!=null){
            System.out.print(resutNode.val+"->");
            resutNode = resutNode.next;
        }
    }
}
