@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes

@param EditPostPage page

@template.layout.page(content = @`
    @if(page.errors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : page.errors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.postPath(page.id())}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Название
                    <input type="text" class="form-control" name="name" value="${page.name()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">Содержание</label>
                <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.body()}</textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Сохранить"/>
        </form>
    </div>
`)