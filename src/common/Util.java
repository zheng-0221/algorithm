package common;

/**
 * @author zpp
 */
public class Util {

    public static ListNode genList(int[] arr) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int elem : arr) {
            cur.next = new ListNode(elem);
            cur = cur.next;
        }
        return head.next;
    }

    public static void showList(ListNode head) {

        StringBuilder str = new StringBuilder("[");
        while (head != null) {
            if (head.next == null) {
                str.append(head.val);
            } else {
                str.append(head.val).append(", ");

            }
            head = head.next;
        }

        str.append("]");
        System.out.println(str);
    }
}
