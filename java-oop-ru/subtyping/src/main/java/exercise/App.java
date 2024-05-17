package exercise;

import java.util.HashMap;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var result = new HashMap<String, String>();

        storage.toMap().forEach((value, key) -> {
            result.put(key, value);
        });

        storage.set(result);
    }
}
// END
