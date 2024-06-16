package exercise;

import exercise.dto.users.UserPageDto;
import exercise.dto.users.UsersPageDto;
import io.javalin.Javalin;

import java.util.List;

import exercise.model.User;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            ctx.render("users/show.jte", model("users", new UsersPageDto(USERS)));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).getOrThrow(stringMap -> new NotFoundResponse(stringMap.toString()));

            var userQuery = USERS.stream().filter(usr -> usr.getId() == id).findFirst();

            if (userQuery.isEmpty()) {
                throw new NotFoundResponse("User with given id is not found");
            }

            var user = userQuery.get();

            var userDto = new UserPageDto(user.getFirstName(), user.getLastName(), user.getEmail());

            ctx.render("users/index.jte", model("user", userDto));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
