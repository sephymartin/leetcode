package top.sephy.leetcode.p460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    int capacity;
    int minFreq = 0;
    Map<Integer, LFUCacheNode> kvMap;
    Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.kvMap = new HashMap<>(capacity);
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        LFUCacheNode obj = kvMap.get(key);
        if (obj == null) {
            return -1;
        }

        freqInc(obj);
        return obj.value;
    }

    void freqInc(LFUCacheNode node) {
        DoubleLinkedList linkedList = freqMap.get(node.freq);
        if(linkedList == null){
            return;
        }

        linkedList.removeNode(node);
        //判断min是否等于当前node的频次，且当前频次的list为空，是的话更新min值
        if(minFreq == node.freq && linkedList.isEmpty()){
            minFreq ++;
        }
        //然后把node频次加 1，并把它放到高频次list
        node.freq++;
        DoubleLinkedList newList = freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList());
        newList.addNode(node);
    }

    private void insertIntoFreqMap(LFUCacheNode node) {
        int freq = node.freq;
        DoubleLinkedList newFreqList = freqMap.computeIfAbsent(freq, k -> new DoubleLinkedList());
        newFreqList.addNode(node);
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        LFUCacheNode obj = kvMap.get(key);
        if (obj != null) {
            obj.value = value;
            freqInc(obj);
            return;
        }

        LFUCacheNode node = new LFUCacheNode(key, value);
        if (kvMap.size() >= capacity) {
            DoubleLinkedList minFreqList = freqMap.get(minFreq);
            if (minFreqList != null) {
                LFUCacheNode last = minFreqList.removeTail();
                if (minFreqList.isEmpty()) {
                    freqMap.remove(minFreq);
                }
                kvMap.remove(last.key);
            }
        }

        insertIntoFreqMap(node);

        // 新插入的节点，频率为1
        minFreq = node.freq;
        kvMap.put(key, node);
    }

    static class LFUCacheNode {

        int key;
        int value;
        int freq;
        LFUCacheNode prev;
        LFUCacheNode next;

        public LFUCacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DoubleLinkedList {
        LFUCacheNode head;
        LFUCacheNode tail;

        public DoubleLinkedList() {
        }

        // 头插法
        public void addNode(LFUCacheNode node) {
            if (head == null) {
                head = tail = node;
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }

        // 删除指定节点
        public void removeNode(LFUCacheNode node) {
            if (node == head) {
                head = node.next;
            }
            if (node == tail) {
                tail = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }

            // 彻底断开节点引用，防止内存泄漏
            node.prev = null;
            node.next = null;
        }

        public LFUCacheNode removeTail() {
            LFUCacheNode last = tail;
            removeNode(tail);
            return last;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static void main(String[] args) {
//        LFUCache cache = new LFUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.get(3);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
//        System.out.println(cache);

        LFUCache cache = new LFUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
        System.out.println(cache);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj = new LFUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */