package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleRating;
import ru.geek.news_portal.base.entities.User;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */
public interface ArticleRatingRepository extends JpaRepository<ArticleRating,Long> {

    public ArticleRating getOneByArticleAndUser(Long article_id, Long user_id);

    @Query("select COALESCE(AVG(value),0) from ArticleRating where article =:id")
    public float getAverageValueOfArticle(@Param("id") Long id);

}
