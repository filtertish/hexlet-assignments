@import exercise.dto.users.UserPageDto
@param UserPageDto user

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All users list</title>
</head>
<body>
<h1>${user.firstName()} ${user.lastName()}</h1>
<p>${user.email()}</p>
<a href="/users">Return to users list</a>
</body>
</html>
