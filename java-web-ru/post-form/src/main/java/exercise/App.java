package exercise;

import exercise.util.Security;
import io.javalin.Javalin;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.post("users", ctx -> {
            var firstName = ctx.formParam("first-name");
            var lastName = ctx.formParam("last-name");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");

            if (firstName == null || lastName == null || email == null || password == null) {
                ctx.redirect("/users");
                return;
            }

            var user = new User(StringUtils.capitalize(firstName.trim()),
                    StringUtils.capitalize(lastName.trim()),
                    email.trim().toLowerCase(),
                    Security.encrypt(password));

            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users/build", ctx -> ctx.render("users/build.jte"));
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
