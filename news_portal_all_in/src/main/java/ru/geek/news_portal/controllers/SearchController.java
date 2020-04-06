/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * SearchController for Search Page
 * @version v1.0
 */

package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.dto.PageLimitDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.utils.ArticleFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/search")
public class SearchController {
    private ArticleService articleService;
    private ArticleCategoryService articleCategoryService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @GetMapping()
    public String search(Model model, HttpServletRequest request, HttpServletResponse response,
                       @CookieValue(value = "page_size", required = false) Integer pageSize,
                       @RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                       @RequestParam(name = "pageLimit", required = false) Integer pageLimit
                       // @RequestParam Map<String, String> params
    ) {
        ArticleFilter articleFilter = new ArticleFilter(request);
        List<ArticleDto> articles = articleService.findAllArticles();
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
            response.addCookie(new Cookie("page_size", String.valueOf(pageSize)));
        }
        if (pageLimit == null) {
            pageLimit = 5;
        }

        model.addAttribute("articles", articles);
        model.addAttribute("categories", articleCategoryService.findAll());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("filters", articleFilter.getFiltersString());

        Page<Article> page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), PageRequest.of(pageNumber - 1, pageLimit, Sort.Direction.ASC, "id"));
        model.addAttribute("page", page);
        return "ui/search";
    }

        @GetMapping("/show_categories")
    public String showSearch(Model model, HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(name = "pageLimit", required = false) Integer pageLimit
                             // @RequestParam Map<String, String> params
        ) {
        return "ui/search";
    }
}
