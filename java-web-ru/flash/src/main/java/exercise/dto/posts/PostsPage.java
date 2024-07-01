package exercise.dto.posts;

import exercise.dto.BasePage;
import exercise.model.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsPage extends BasePage {
    private final List<Post> posts;

    public PostsPage(List<Post> posts, String flash) {
        super(flash);
        this.posts = posts;
    }
}
