package top.sephy.leetcode.p21;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeKLists(new ListNode[]{list1, list2});
    }

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
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
