/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * SearchController for Search article Page, and show Categories Page
 * @version v1.10 (30/04/2020)
 */

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
import ru.geek.news_portal.base.entities.Tag;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.TagsServiceImpl;
import ru.geek.news_portal.utils.ArticleFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class SearchController {
    private ArticleService articleService;
    private ArticleCategoryService articleCategoryService;
    private TagsServiceImpl tagsService;

    private Long RECOMENDED_NEWS = 5L;
    private final Integer PAGE_LIMIT = 50;

    @Autowired
    public SearchController (ArticleCategoryService articleCategoryService,
                             ArticleService articleService,
                             TagsServiceImpl tagsService) {
        this.articleCategoryService = articleCategoryService;
        this.articleService = articleService;
        this.tagsService = tagsService;
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam Map<String, String> params,
                         @PathVariable (value = "id", required = false) Long id,
                         HttpServletRequest request, HttpServletResponse response,
                         @RequestParam (value = "cat_id", required = false) ArrayList<String> catIdArr,
                         @RequestParam (value = "tag_id", required = false) ArrayList<String> tagIdArr,
                         @RequestParam (value = "search", required = false) String search,
                         @RequestParam (value = "page", required = false) Page<Article> page,
                         @CookieValue(value = "limit", required = false) Integer pageLimit) {

        Integer pageNumber = 0;
        List<Integer> catIdInteger = new ArrayList<Integer>();
        List<Integer> tagIdInteger = new ArrayList<Integer>();
        Tag tag = null;
        ArticleCategory cat = null;

        if (params.containsKey("pageNumber")) { 
            pageNumber = Integer.parseInt(params.get("pageNumber")) - 1;
        }
        if (pageLimit == null) {
            response.addCookie(new Cookie("limit", String.valueOf(PAGE_LIMIT)));
        }
        if (params.containsKey("limit")) {
            int lim = Integer.parseInt(params.get("limit"));
            if (lim>0) {
                pageLimit = lim;
            }
        }

        if (params.containsKey("cat_id")) {
            if (catIdArr.size()>0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (catIdArr.contains("") && catIdArr.size()>1){
                    catIdArr.remove("");
                }
                stringBuilder.append(catIdArr.get(0));
                catIdInteger.add(Integer.parseInt(catIdArr.get(0)));
                for (int i = 1; i < catIdArr.size(); i++) {
                    stringBuilder.append("," + catIdArr.get(i));
                    catIdInteger.add(Integer.parseInt(catIdArr.get(i)));
                }
                params.put("cat_id", stringBuilder.toString());
            }
            if (catIdArr.size()==1) {
                cat = articleCategoryService.findOneById(Long.parseLong(params.get("cat_id")));
            }
        }
        if (params.containsKey("tag_id")&&params.get("tag_id")!="") {
            if (tagIdArr.size()==1) {
                tagIdInteger.add(Integer.parseInt(tagIdArr.get(0)));
                params.put("tag_id", tagIdArr.get(0));
                tag = tagsService.findById(Long.parseLong(params.get("tag_id")));
            }
        }

        if (catIdArr != null && catIdArr.size()==1) {
            cat = articleCategoryService.findOneById(Long.parseLong(params.get("cat_id")));
        }

        if (tagIdArr != null && tagIdArr.size()==1) {
            tag = tagsService.findById(Long.parseLong(params.get("tag_id")));
        }

        if (params.containsKey("search")) {
            if (params.get("search").contains("all")) {
                catIdInteger.add(0);
                if (params.get("word").length()==0) {
                    params.put("cat_id", "0");
                }
            }
            params.put("search", search);
        }

        ArticleFilter articleFilter = new ArticleFilter(params);
        List<ArticleDto> articlesDto = articleService.findAllDtoArticles();
        Pageable pageRequest = PageRequest.of(pageNumber, pageLimit, Sort.Direction.ASC, "id");
        if (page==null) {
            page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), pageRequest);
        }
        model.addAttribute("filtersDef", articleFilter.getFilterDefinition());
        model.addAttribute("filtersDefCat", articleFilter.getFilterDefinitionCat());
        model.addAttribute("catIdInteger", catIdInteger);
        model.addAttribute("search", search);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("tag", tag);
        model.addAttribute("cat", cat);
        model.addAttribute("page", page);
        if (params.containsKey("search")&&params.get("search").contains("all")) {
            return "ui/search";
        } else {
            return "ui/category";
        }
    }
}
