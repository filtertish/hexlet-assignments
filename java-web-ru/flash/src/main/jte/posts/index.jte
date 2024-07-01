@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(content = @`
    @if(page.getFlash() != null)
        <h1>${page.getFlash()}</h1>
    @endif
    @if(!page.getPosts().isEmpty())
        @for(var post : page.getPosts())
            <p>${post.getName()}</p>
            <p>${post.getBody()}</p>
        @endfor
    @else
        <p>No posts yet</p>
    @endif
`)