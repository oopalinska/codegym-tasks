package task3413_soft_reference;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //write your code here
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));

        //write your code here
        if (softReference == null) {
            return null;
        }
        AnyObject obj = softReference.get();
        softReference.clear();
        return obj;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        //write your code here
        if (softReference == null) {
            return null;
        }
        AnyObject obj = softReference.get();
        softReference.clear();
        return obj;
    }
}
