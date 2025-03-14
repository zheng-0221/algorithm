package leetcode;

import common.ListNode;

/**
 * @author zpp
 */
public class Question_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int exact = 0;
        ListNode cur = new ListNode();
        ListNode ans = cur;
        while (l1 != null || l2 != null) {
            int temp = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + exact;
            cur.next = new ListNode(temp % 10);
            exact = temp / 10;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (exact > 0) {
            cur.next = new ListNode(1);
        }
        return ans.next;
    }
}
