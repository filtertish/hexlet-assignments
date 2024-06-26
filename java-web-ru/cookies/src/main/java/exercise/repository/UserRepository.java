package exercise.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exercise.model.User;

public class UserRepository {
    private static List<User> entities = new ArrayList<User>();

    public static Long save(User user) {
        var id = (long) entities.size() + 1;
        user.setId(id);
        entities.add(user);
        return id;
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getFirstName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var user = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
        return user;
    }

    public static void delete(Long id) {

    }

    public static List<User> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
