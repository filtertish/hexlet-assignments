package exercise.dto.articles;

import java.util.List;

// BEGIN
public record BuildArticlePage(String title, String content, List<String> errors) {
};
// END
