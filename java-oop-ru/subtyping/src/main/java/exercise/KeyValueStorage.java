package exercise;

import java.util.Map;

interface KeyValueStorage {
    void set(String key, String value);
    void set(Map<String, String> newStorage);
    void unset(String key);
    String get(String key, String defaultValue);
    Map<String, String> toMap();
}
