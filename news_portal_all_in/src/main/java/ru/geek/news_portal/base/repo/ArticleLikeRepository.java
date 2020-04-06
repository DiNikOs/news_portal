package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geek.news_portal.base.entities.ArticleLike;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 */
public interface ArticleLikeRepository extends JpaRepository<ArticleLike,ArticleLike.ArticleLikeId> {

    public Long getArticleLikesByArticleAndValue(Long article_id, Integer value);

    public Long getDistinctByArticleAndValue(Long article_id, Integer value);

    @Query("select sum(a.value) from ArticleLike a where a.article = :article_id and a.value = :value")
    public Integer getArticleLikesOrDislikes(@Param("article_id") Long article_id, @Param("value") Integer value);

}
