package exercise.controller;

import com.sun.source.doctree.ValueTree;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        if (password == null || firstName == null || lastName == null || email == null) {
            ctx.redirect(NamedRoutes.usersPath());
            return;
        }

        var token = Security.generateToken();
        ctx.cookie("token", token);

        var user = new User(firstName, lastName, email, password, token);
        var id = UserRepository.save(user);
        ctx.status(302).redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context ctx) {
        var token = ctx.cookie("token");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).orElseThrow(NotFoundResponse::new);

        if (user.getToken().equals(token)) {
            ctx.render("users/show.jte", model("page", new UserPage(user)));
            return;
        }

        ctx.redirect(NamedRoutes.buildUserPath());
    }
    // END
}
