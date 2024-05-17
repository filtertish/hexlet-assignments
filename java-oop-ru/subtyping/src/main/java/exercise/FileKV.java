package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final String filePath;

    FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(storage));
    }


    @Override
    public void set(String key, String value) {
        var storage = Utils.unserialize(Utils.readFile(filePath));
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void set(Map<String, String> newStorage) {
        Utils.writeFile(filePath, Utils.serialize(newStorage));
    }

    @Override
    public void unset(String key) {
        var storage = Utils.unserialize(Utils.readFile(filePath));
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        return Utils.unserialize(Utils.readFile(filePath)).getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(filePath));
    }
}
// END
