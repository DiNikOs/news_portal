package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.TagsService;
import ru.geek.news_portal.utils.ArticleFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private ArticleService articleService;
    private ArticleCategoryService articleCategoryService;

    private Long RECOMENDED_NEWS = 5L;

    @Autowired
    public void setArticleService(ArticleService articleService) {


@Autowired
    public CategoryController(ArticleService articleService,
                              ArticleCategoryService articleCategoryService) {

        this.articleService = articleService;
        this.articleCategoryService = articleCategoryService;
    }

    @GetMapping({"/{id}", ""})
    public String categoryShow(Model model,
                               @RequestParam Map<String, String> params,
                               HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "page_size", required = false) Integer pageSize
                               ,@PathVariable (value = "id", required = false) Long id
    ) {
        Integer pageNumber = 0;
        Integer pageLimit = 5;
        ArticleCategory category = null;
        if (params.size()==0) {
            if (id==null) {
                params.put("cat_id", "");
            } else {
                params.put("cat_id", id.toString());
            }
        }
        if (params.containsKey("pageNumber")) {
            pageNumber = Integer.parseInt(params.get("pageNumber")) - 1;
        }
        if (pageSize == null) {
            pageSize = 10;
            response.addCookie(new Cookie("page_size", String.valueOf(pageSize)));
        }
        if (params.containsKey("limit")) {
            int lim = Integer.parseInt(params.get("limit"));
            if (lim>0) {
                pageLimit = Integer.parseInt(params.get("limit"));
            }
        }
        if (params.containsKey("cat_id") && params.get("cat_id").length()>0) {
            category = articleCategoryService.findOneById(Long.parseLong(params.get("cat_id")));
        }

        ArticleFilter articleFilter = new ArticleFilter(params);
        List<ArticleDto> articles = articleService.findAllArticles();
        List<ArticleCategory> categories = articleCategoryService.findAll();

        Pageable pageRequest = PageRequest.of(pageNumber, pageLimit, Sort.Direction.ASC, "id");
        Page<Article> page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), pageRequest);

        model.addAttribute("filtersDef", articleFilter.getFilterDefinition());
        model.addAttribute("articles", articles);
        model.addAttribute("category", category);
        model.addAttribute("categories", categories);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("page", page);
        return "ui/category";
    }
}
