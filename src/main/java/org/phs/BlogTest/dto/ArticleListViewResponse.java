package org.phs.BlogTest.dto;

import lombok.Getter;
import org.phs.BlogTest.domain.Article;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.content = article.getContent();
        this.title = article.getTitle();
    }
}
