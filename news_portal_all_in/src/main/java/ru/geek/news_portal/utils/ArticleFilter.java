/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * ArticleFilter for SearchController
 * @version v1.0
 */

package ru.geek.news_portal.utils;

import org.springframework.data.jpa.domain.Specification;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.specifications.ArticleSpecifications;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ArticleFilter {
    private Specification<Article> specification;
    private StringBuilder filtersString;

    public Specification<Article> getSpecification() {
        return specification;
    }

    public StringBuilder getFiltersString() {
        return filtersString;
    }

    public ArticleFilter(HttpServletRequest request) {
        filtersString = new StringBuilder();
        specification = Specification.where(null);

        if (request.getParameter("word") != null && !request.getParameter("word").isEmpty()) {
            specification = specification.and(ArticleSpecifications.titleContains(request.getParameter("word")));
            filtersString.append("&word=" + request.getParameter("word"));
        }

        if (request.getParameter("limit") != null && !request.getParameter("limit").isEmpty()) {
            specification = specification.and(ArticleSpecifications.limitNavTab(new BigDecimal(request.getParameter("limit"))));
            filtersString.append("&limit=" + request.getParameter("limit"));
        }

        if (request.getParameter("catId") != null && !request.getParameter("catId").isEmpty()) {
            specification = specification.and(ArticleSpecifications.categoryId(Long.valueOf(request.getParameter("catId"))));
            filtersString.append("&catId=" + request.getParameter("catId"));
        }
    }
}
