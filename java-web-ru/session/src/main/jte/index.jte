@param String username = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hexlet</title>
</head>
<body>
@if(username == null)
    <a href="${exercise.util.NamedRoutes.buildSessionPath()}">Войти</a>
@else
    <p>${username}</p>
    <form action="${exercise.util.NamedRoutes.logoutPath()}" method="post">
        <button>Выйти</button>
    </form>
@endif
</body>
</html>