package exercise;

import com.sun.source.doctree.ValueTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        var fields = address.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();

        for (var field : fields) {
            try {
                field.setAccessible(true);

                if (field.get(address) == null && field.getAnnotation(NotNull.class) != null) {
                    result.add(field.getName());
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        var result = new HashMap<String, List<String>>();
        var fields = address.getClass().getDeclaredFields();

        for (var field : fields) {
            field.setAccessible(true);
            var errors = new ArrayList<String>();
            String key = field.getName();

            try {
                var value = field.get(address);

                if (value == null && field.getAnnotation(NotNull.class) != null) {
                    errors.add("can not be null");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            try {
                var value = field.get(address);

                var minLength = field.getAnnotation(MinLength.class);

                if ((minLength != null && value != null) && value.toString().length() < minLength.minLength()) {
                    errors.add("length less than " + minLength.minLength());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (!errors.isEmpty()) {
                result.put(key, errors);
            }
        }
        return result;
    }
}
// END
