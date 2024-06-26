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
        <a href="${NamedRoutes.postsPath(page.page() - 1 > 0 ? page.page() - 1 : 1)}">previous</a>
        <a href="${NamedRoutes.postsPath(page.posts().size() < 5 ? page.page() : page.page() + 1)}">next</a>
    @endif
`)