package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();

        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        if (page < 1) page = 1;
        if (page > posts.size() / 5) page = posts.size() / 5;

        ctx.render("posts/index.jte", model("page",
                new PostsPage(posts.subList((page - 1) * 5, page * 5), page, posts.size())));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        var post = PostRepository.find(id);

        if (id == null || post.isEmpty()) {
            throw new NotFoundResponse("Page not found");
        }

        ctx.render("posts/show.jte", model("post", new PostPage(post.get())));
    }
    // END
}
