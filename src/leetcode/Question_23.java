package leetcode;

import common.ListNode;
import common.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zpp
 */
public class Question_23 {

    public static void main(String[] args) {
        //[1,4,5],[1,3,4],[2,6]
        Util.showList(
                mergeKLists(
                        new ListNode[]{
                                Util.genList(new int[]{1, 4, 5}),
                                Util.genList(new int[]{1, 3, 4}),
                                Util.genList(new int[]{2, 6})
                        }
                ));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        if (head.next != null) {
            heap.add(head.next);
        }
        ListNode cur = head;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                heap.add(minNode.next);
            }
        }

        return head;
    }

}
