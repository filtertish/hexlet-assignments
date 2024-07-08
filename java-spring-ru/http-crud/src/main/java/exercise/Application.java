package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    List<Post> index(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (limit * page < posts.size() && limit * page > 0) {
            return posts.subList((page - 1) * limit, limit * page);
        }

        return posts;
    }

    @GetMapping("/posts/{id}")
    Optional<Post> show(@PathVariable("id") String id) {
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @PostMapping("/posts")
    Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping(value = "/posts/{id}", consumes = {"application/json"})
    Post update(@RequestBody Post post, @PathVariable String id) {
        var oldPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (oldPost.isPresent()) {
            var temp = oldPost.get();
            temp.setId(post.getId());
            temp.setTitle(post.getTitle());
            temp.setBody(post.getBody());
        }

        return post;
    }

    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
    // END
}
