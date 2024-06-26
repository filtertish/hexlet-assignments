@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param PostPage post

@template.layout.page(content = @`
    <a href="${NamedRoutes.postsPath()}">back to posts</a>
    <p>${post.getPost().getName()}</p>
    <p>${post.getPost().getBody()}</p>
`)