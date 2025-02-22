package top.sephy.leetcode.p146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity = 0;

    Map<Integer, LRUCacheDataNode> map;

    LRUCacheDataNode head = null;
    LRUCacheDataNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        LRUCacheDataNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {

        LRUCacheDataNode old = map.get(key);
        if (old != null) {
            old.val = value;
            moveToHead(old);
            return;
        }

        if (map.size() >= capacity) {
            if (tail != null) {
                // remove tail
                map.remove(tail.key);
                if (tail.prev != null) {
                    tail.prev.next = null;
                    tail = tail.prev;
                }
            }
        }

        LRUCacheDataNode node = new LRUCacheDataNode();
        node.key = key;
        node.val = value;
        insertHead(node);

        map.put(key, node);
    }

    private void insertHead(LRUCacheDataNode node) {

        if (head == null) {
            head = node;
            tail = head;
            return;
        }

        LRUCacheDataNode tmp = head;
        head = node;
        tmp.prev = node;
        node.next = tmp;
    }

    private void moveToHead(LRUCacheDataNode node) {
        if (head != node) {
            LRUCacheDataNode tmp = head;

            head = node;

            // tail node
            if (tail == node) {
                if (node.prev != null) {
                    node.prev.next = null;
                }
                tail = node.prev;
            }

            // mid node
            if (node.next != null && node.prev != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.next = tmp;
            tmp.prev = node;
        }
    }

    class LRUCacheDataNode {

        LRUCacheDataNode prev;

        LRUCacheDataNode next;

        int key;

        int val;
    }

    public static void main(String args[]) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
    }
}
