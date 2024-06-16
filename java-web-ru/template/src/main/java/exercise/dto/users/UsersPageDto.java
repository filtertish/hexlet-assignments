package exercise.dto.users;

import exercise.model.User;

import java.util.List;

// BEGIN
public record UsersPageDto(List<User> users) {
}
// END
