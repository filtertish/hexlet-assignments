package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(int id) {
        return "/posts?page=" + id;
    }

    public static String postPath(Long id) {
        return "/posts/" + id;
    }

    public static String postPath() {
        return "/posts/{id}";
    }
    // END
}
