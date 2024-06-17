@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
show = @`
    <a href="/">Return to main</a>
    <p>${page.getUser().getFirstName()}</p>
    <p>${page.getUser().getLastName()}</p>
    <p>${page.getUser().getEmail()}</p>
`
)
