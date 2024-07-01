package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var username = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UsersRepository.findByName(username);

        if (user == null || !user.getPassword().equals(Security.encrypt(password))) {
            ctx.status(302).render("build.jte", model("error", "Wrong username or password."));
            return;
        }

        ctx.sessionAttribute("currentUser", user.getName());
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
