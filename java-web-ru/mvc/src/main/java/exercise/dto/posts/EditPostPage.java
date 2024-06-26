package exercise.dto.posts;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;

// BEGIN
public record EditPostPage(Long id, String name, String body, Map<String, List<ValidationError<Object>>> errors) {
}
// END
