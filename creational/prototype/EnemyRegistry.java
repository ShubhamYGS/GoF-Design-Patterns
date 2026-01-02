package prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps a map of prototype instances and returns clones on request.
 * Clients register prototype objects, and the registry produces new
 * instances via clone() so clients can customize clones without
 * affecting prototypes.
 */
class EnemyRegistry {
    private Map<String, EnemyPrototype> prototypes = new HashMap<>();

    public void register(String key, EnemyPrototype prototype) {
        prototypes.put(key, prototype);
    }

    public EnemyPrototype get(String key) {
        EnemyPrototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("No prototype registered for: " + key);
    }
}