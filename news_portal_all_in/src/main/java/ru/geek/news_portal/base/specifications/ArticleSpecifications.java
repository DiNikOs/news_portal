/**
 * @author Ostrovskiy Dmitriy
 * @created 04/04/2020
 * ArticleSpecifications for SearchController
 * @version v1.10 (30/04/2020)
 */

package ru.geek.news_portal.base.specifications;

import org.springframework.data.jpa.domain.Specification;

import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.Tag;
import ru.geek.news_portal.dto.ArticleDto;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.math.BigDecimal;
import java.util.Collection;

public class ArticleSpecifications {
    public static Specification<Article> titleContains(String word) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Article> limitNavTab(Integer value) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("limit").get("value"), value);
        }

    public static Specification<Article> articleId(Long articleId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id").get("id"), articleId);
    }

    public static Specification<Article> categoryId(Long catId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
           criteriaBuilder.equal(root.get("category").get("id"), catId);
        }
        // spec many to many
    public static Specification<Article> tagsId(Long tagId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) -> {
                criteriaQuery.distinct(true);
                Root<Article> article = root;
                Root<Tag> tag = criteriaQuery.from(Tag.class);
                Expression<Collection<Article>> tagsArticle = tag.get("articles");
                return criteriaBuilder.and(criteriaBuilder.equal(tag.get("id"), tagId),
                        criteriaBuilder.isMember(article, tagsArticle));
        };
    }
}
