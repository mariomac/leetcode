package g100.g140.p146lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCache_slow {

    private Map<Integer,Integer> keyValues = new HashMap<>();
    private Map<Integer,Integer> keyLastAccess = new HashMap<>();
    private TreeMap<Integer,Integer> lastAccessKey = new TreeMap<>();

    private int accesses = 0;
    private int capacity;

    public LRUCache_slow(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer ret = keyValues.get(key);
        if(ret == null) {
            return -1;
        } else {
            updateLruInfo(key);
            return ret;
        }
    }

    public void set(int key, int value) {
        keyValues.put(key,value);
        updateLruInfo(key);
        if(keyValues.size() > capacity) {
            int lruKey = lastAccessKey.remove(lastAccessKey.firstKey());
            keyLastAccess.remove(lruKey);
            keyValues.remove(lruKey);
        }
    }

    private void updateLruInfo(int key) {
        Integer lastAccessForKey = keyLastAccess.get(key);
        if(lastAccessForKey != null) {
            lastAccessKey.remove(lastAccessForKey);
        }
        accesses++;
        keyLastAccess.put(key,accesses);
        lastAccessKey.put(accesses,key);
    }
}