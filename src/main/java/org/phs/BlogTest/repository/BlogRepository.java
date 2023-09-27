package org.phs.BlogTest.repository;

import org.phs.BlogTest.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}