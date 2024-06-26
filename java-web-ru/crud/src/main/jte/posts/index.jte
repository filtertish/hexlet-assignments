@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page = null

@template.layout.page(content = @`
    @if(page == null)
        <p>no posts yet</p>
    @else
        <ul>
            @for(var post : page.posts())
                <li>
                    <a href="${NamedRoutes.postPath(post.getId())}"><p>${post.getName()}</p></a>
                </li>
            @endfor
        </ul>
        @if(page.page() > 1)
            <a href="${NamedRoutes.postsPath(page.page() - 1)}">previous</a>
        @endif
        @if(page.page() * 5 < page.max() - 5)
            <a href="${NamedRoutes.postsPath(page.page() + 1)}">next</a>
        @endif
    @endif
`)