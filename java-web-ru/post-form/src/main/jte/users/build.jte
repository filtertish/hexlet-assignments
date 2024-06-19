@template.layout.page(content = @`
    <form action="/users" method="post">
        <label>
            first name
            <input type="text" name="first-name" required>
        </label>
        <label>
            last name
            <input type="text" name="last-name" required>
        </label>
        <label>
            email
            <input type="text" name="email" required>
        </label>
        <label>
            password
            <input type="text" name="password" required>
        </label>
        <button>add user</button>
    </form>
`)