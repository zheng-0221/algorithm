package leetcode;

import common.ListNode;
import common.Util;

/**
 * @author zpp
 */
public class Question_19 {

    public static void main(String[] args) {
        ListNode head = Util.genList(new int[]{1, 2, 3, 4, 5});
        head = removeNthFromEnd(head, 2);
        Util.showList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }


        int pos = 1;
        ListNode rear = head;
        while (pos < n) {
            rear = rear.next;
            pos++;
        }

        ListNode pre = head;
        ListNode reNth = head;
        pos = 1;
        while (rear.next != null) {
            if (pos != 1) {
                pre = pre.next;
            }
            reNth = reNth.next;
            rear = rear.next;
            pos++;
        }

        if (pos == 1) {
            return head.next;
        }

        pre.next = pre.next.next;

        return head;
    }

}
