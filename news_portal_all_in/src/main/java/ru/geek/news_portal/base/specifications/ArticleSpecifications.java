/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * ArticleSpecifications for SearchController
 * @version v1.0
 */

package ru.geek.news_portal.base.specifications;

import org.springframework.data.jpa.domain.Specification;

import ru.geek.news_portal.base.entities.Article;

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

    public static Specification<Article> categoryId(Long catId) {
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) ->
           criteriaBuilder.equal(root.get("category").get("id"), catId);
        }



//        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
//                criteriaBuilder.equal(root.get("category").get("id"), id);
//    }
}
