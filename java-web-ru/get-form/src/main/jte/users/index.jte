@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <label for="user-input"></label>
        <input type="text" required name="term" id="user-input" value="${page.term()}">
        <button>Find</button>
        @for(var user : page.users())
            <p>${user.getFirstName()} ${user.getLastName()}</p>
            <p>${user.getEmail()}</p>
        @endfor
    </form>
`)