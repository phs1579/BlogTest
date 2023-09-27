package org.phs.BlogTest.service;

import lombok.RequiredArgsConstructor;
import org.phs.BlogTest.dto.AddArticleRequest;
import org.phs.BlogTest.domain.Article;
import org.phs.BlogTest.dto.UpdateArticleRequest;
import org.phs.BlogTest.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;
    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("not found : "+ id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
