package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> {
            var username = ctx.sessionAttribute("currentUser");
            ctx.render("index.jte", model("username", username));
        });
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(), SessionsController::create);
        app.post(NamedRoutes.logoutPath(), SessionsController::delete);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
