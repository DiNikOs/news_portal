package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
