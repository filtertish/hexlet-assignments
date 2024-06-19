package exercise.dto.users;

import exercise.model.User;

import java.util.List;

import lombok.Getter;

// BEGIN
public record UsersPage(List<User> users) {
}
// END
