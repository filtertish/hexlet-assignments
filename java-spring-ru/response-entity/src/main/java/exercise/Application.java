package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

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
    ResponseEntity<List<Post>> index(@RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        limit = limit > posts.size() ? posts.size() : limit;

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts.subList(0, limit));
    }

    @GetMapping("posts/{id}")
    ResponseEntity<Post> show(@PathVariable String id) {
        var post = posts.stream().filter(p -> p.getId().equals(id)).findFirst();

        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @PostMapping(value = "posts", consumes = {"application/json"})
    ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(201).body(post);
    }

    @PutMapping(value = "posts/{id}")
    ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post post) {
        var oldPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (oldPost.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }

        oldPost.get().setTitle(post.getTitle());
        oldPost.get().setBody(post.getBody());

        return ResponseEntity.status(200).body(post);
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
