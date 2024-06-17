@import gg.jte.Content

@param Content header = null
@param Content footer = null
@param Content show = null
@param Content index = null
@param Content main = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Page</title>
</head>
<body>
<header>${header}</header>
<main>
    ${main}
    ${index}
    ${show}
</main>
<footer>${footer}</footer>
</body>
</html>