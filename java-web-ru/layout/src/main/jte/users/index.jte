@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
index = @`
    @if(page.getUsers().isEmpty())
        <p>No users found</p>
    @else
        @for(var user : page.getUsers())
            <a href="users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
            <p>${user.getEmail()}</p>
        @endfor
    @endif
`,
header = @`
    <a href="/">Main</a>
    <a href="/users">All users</a>
`,
footer = @`
    <p>footer string</p>
`
)
