package exercise.dto.posts;

import java.util.List;

import exercise.model.Post;


// BEGIN
public record PostsPage(List<Post> posts, int page, int max) {
}
// END


