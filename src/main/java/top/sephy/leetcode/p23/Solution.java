package top.sephy.leetcode.p23;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListsWrapper wrapper = new ListsWrapper(lists);
        ListNode head = null;
        ListNode current = null;
        while (true) {
            ListNode min = wrapper.nextMinVal();
            if (min == null) {
                break;
            }
            if (head == null) {
                head = min;
            } else {
                current.next = min;
            }
            current = min;
        }
        return head;
    }

    public static class ListsWrapper {
        ListNode[] lists;
        ListNode[] pointers;

        public ListsWrapper(ListNode[] lists) {
            this.lists = lists;
            this.pointers = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                pointers[i] = lists[i];
            }
        }

        public ListNode nextMinVal() {
            ListNode min = null;
            int minIndex = -1;
            for (int i = 0; i < pointers.length; i++) {
                if (pointers[i] != null) {
                    if (min == null || pointers[i].val < min.val) {
                        min = pointers[i];
                        minIndex = i;
                    }
                }
            }
            if (minIndex > -1 && pointers[minIndex] != null) {
                pointers[minIndex] = pointers[minIndex].next;
            }
            return min;
        }
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        Solution solution = new Solution();
        ListNode head = solution.mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
