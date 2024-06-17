@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
show = @`
    <p>${page.getUser().getFirstName()}</p>
    <p>${page.getUser().getLastName()}</p>
    <p>${page.getUser().getEmail()}</p>
`,
header = @`
    <a href="/">Main</a>
    <a href="/users">All users</a>
`,
footer = @`
    <p>footer string</p>
`
)
