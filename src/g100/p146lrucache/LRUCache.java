package g100.p146lrucache;

import java.util.*;

public class LRUCache {

    private Map<Integer,Node> keyValues = new HashMap<>();
    private Node tail = null, head = null;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = keyValues.get(key);
        if(n == null) {
            return - 1;
        }
        update(n);
        return n.value;
    }

    public void set(int key, int value) {
        Node n = keyValues.get(key);
        if(n == null) {
            n = new Node(key,value);
            keyValues.put(key,n);
            if(tail == null) {
                tail = n;
                head = n;
            }
            if(keyValues.size() > capacity) {
                Node t = keyValues.remove(tail.key);
                tail = tail.next;
            }
        } else {
            n.value = value;
            update(n);
        }
    }

    private void update(Node n) {
        if(tail == null && head == null) {
            tail = head = n;
        } else if(n == tail) {
            if(n != head) {
                tail = n.next;
                n.previous = head;
                head = n;
            }
        } else if(n != head) {
            if(n.previous != null) n.previous.next = n.next;
            if(n.next != null) n.next.previous = n.previous;
            head.next = n;
            n.previous = head;
            n.next = null;
            head = n;
        }
    }

    private class Node {
        Node previous = null;
        Node next = null;
        int value;
        int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}