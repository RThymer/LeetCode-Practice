import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRU<K, V> {
    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;
    private final HashMap<K, Entry<K, V>> map = new HashMap<>();

    public LRU(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
    }

    public void put(K key, V value) {
        Entry entry = map.get(key);
        if (entry == null) {
            //不存在这个条目
            if (map.size() >= MAX_CACHE_SIZE) {
                //此时条目数量超过上限
                map.remove(last.key);
                removeLast(); //维护last节点
            }
            entry = new Entry();
            entry.key = key;
        }
        //已包装好新的entry
        entry.value = value;
        moveToFirst(entry);
        map.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = map.get(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        //从链表中删除一个节点
        Entry<K, V> entry = map.get(key);
        if (entry != null) {
            //中间节点
            if (entry.pre != null) entry.pre.next = entry.next;
            if (entry.next != null) entry.next.pre = entry.pre;
            //首尾节点情况
            if (entry == first) first = entry.next;
            if (entry == last) last = entry.pre;
        }
        map.remove(key);
    }

    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        if (entry == last) last = last.next;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;

        if (first == null || last == null) {
            //
            first = last = entry; //?
            return;
        }
        //置于first之前
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null; //只剩下一个节点
            else last.next = null;
        }
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry pre;
        Entry next;
    }
}

class LRU_Extend_LinkedHashmap<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LRU_Extend_LinkedHashmap(int cacheSize) {
        //指定accessOrder为true即可作为LRU
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.MAX_CACHE_SIZE = cacheSize;
    }

    //重写removeEldestEntry()方法，该方法被put()、putAll()调用
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append("Key: " + entry.getKey() + ", Value: " + entry.getValue() + "; ");
        }
        return sb.toString();
    }
}

class LRU_Use_LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;
    private final float LOAD_FACTOR = 0.75f;
    private final LinkedHashMap<K, V> map;

    //重点：LinkedHashMap、accessOrder、覆盖removeEldestEntry()方法;
    public LRU_Use_LinkedHashMap(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / LOAD_FACTOR) + 1;
        this.map = new LinkedHashMap<K, V>(capacity, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    //因为没有继承Map，相关的操作需要自己写
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getEntrySet() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : getEntrySet()) {
            sb.append("Key: " + entry.getKey() + ", Value: " + entry.getValue() + "; ");
        }
        return sb.toString();
    }
}