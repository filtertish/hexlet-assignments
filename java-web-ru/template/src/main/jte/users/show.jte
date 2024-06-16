@import exercise.dto.users.UsersPageDto
@param UsersPageDto users

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All users list</title>
</head>
<body>
@for(var user : users.users())
    <a href="/users/${user.getId()}"><h1>${user.getFirstName()} ${user.getLastName()}</h1></a>
@endfor
</body>
</html>