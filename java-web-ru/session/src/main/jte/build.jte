@param String error = null

@template.layout.page(content = @`
    @if(error != null)
        <p>${error}</p>
    @endif
    <form action="${exercise.util.NamedRoutes.loginPath()}" method="post">
        <label>
            username
            <input type="text" name="name">
        </label>
        <label>
            password
            <input type="text" name="password">
        </label>
        <button>register</button>
    </form>
`)