package g100.p146lrucache;


public class Main {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.set(2,1);
        System.out.println(lru.get(2));
        lru.set(3,2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
	}
}
