@import exercise.dto.articles.BuildArticlePage

@param BuildArticlePage page = null

@template.layout.page(content = @`
    <form action="/articles" method="post">
        <label>
            Title
                <input type="text" name="title" value="${page.title()}" required>
        </label>
        <label>
            Content
                <textarea name="content" required>${page.content()}</textarea>
        </label>
        <button>add article</button>
        @if(!page.errors().isEmpty())
            @for(var error : page.errors())
                <p>${error}</p>
            @endfor
        @endif
    </form>
`)