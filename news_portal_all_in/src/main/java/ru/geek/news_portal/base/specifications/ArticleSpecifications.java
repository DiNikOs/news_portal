/**
 * @author Ostrovskiy Dmitriy
 * @created 04/04/2020
 * ArticleSpecifications for SearchController
 * @version v1.0
 */

package ru.geek.news_portal.base.specifications;

import org.springframework.data.jpa.domain.Specification;

import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.dto.ArticleDto;

import java.math.BigDecimal;

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

    public static Specification<Article> tagsId(Long tagId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("tag_id").get("id"), tagId);
    }

    public static Specification<Article> editId(Long editId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("edit").get("id"), editId);
    }

    public static Specification<Article> deleteId(Long deleteId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("delete").get("id"), deleteId);
    }


//        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
//                criteriaBuilder.equal(root.get("category").get("id"), id);
//    }
}
