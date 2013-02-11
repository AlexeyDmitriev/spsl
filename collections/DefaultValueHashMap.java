package collections;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 * Date: 8/26/12
 * Time: 11:08 PM
 */
public class DefaultValueHashMap<K, V> extends HashMap<K, V> {
    private V defaultValue;

    public DefaultValueHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        if (!containsKey(key)) {
            put((K) key, defaultValue);
            return defaultValue;
        }
        return super.get(key);
    }
}
