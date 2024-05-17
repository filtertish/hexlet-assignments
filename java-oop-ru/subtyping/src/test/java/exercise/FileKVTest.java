package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testFileKV() {
        var storage = new FileKV(filepath.toString(), Map.of());

        //Test 1
        var testStorage = Map.of("hello", "world");
        storage.set("hello", "world");
        Assertions.assertEquals(testStorage.get("hello"), storage.get("hello", "error"));

        //Test 2
        var testStorage2 = Map.of("hello", "world", "test", "second");
        storage.set("test", "second");
        Assertions.assertEquals(testStorage2.get("hello"), storage.get("hello", "error"));
        Assertions.assertEquals(testStorage2.get("test"), storage.get("test", "error"));

        //Test 3
        storage.unset("test");
        Assertions.assertEquals(testStorage.get("hello"), storage.get("hello", "error"));
        Assertions.assertEquals(storage.get("test", "null"), "null");
    }
    // END
}
