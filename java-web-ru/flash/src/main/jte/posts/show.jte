@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(

content = @`
    <div class="mb-3">
        <h1>${page.post().getName()}</h1>
    </div>

    <div class="mb-3">
        ${page.post().getBody()}
    </div>
`
)
