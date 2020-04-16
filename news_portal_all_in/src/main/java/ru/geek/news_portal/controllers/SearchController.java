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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.dto.PageLimitDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.utils.ArticleFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
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
    public String search(Model model, @RequestParam Map<String, String> params,
                         HttpServletRequest request, HttpServletResponse response,
                         @RequestParam (value = "cat_id", required = false) ArrayList<String> catIdArr,
                         @CookieValue(value = "page_size", required = false) Integer pageSize) {
        Integer pageNumber = 0;
        Integer pageLimit = null;
        pageLimit = articleService.findAllArticles().size();

        ArticleCategory category = null;
        List<Integer> catIdInteger = new ArrayList<Integer>();

        if (params.containsKey("pageNumber")) { 
            pageNumber = Integer.parseInt(params.get("pageNumber")) - 1;
        }
        if (pageSize == null) {
            pageSize = 4;
            response.addCookie(new Cookie("page_size", String.valueOf(pageSize)));
        }
        if (params.containsKey("limit")) {
            int lim = Integer.parseInt(params.get("limit"));
            if (lim>0) {
                pageLimit = Integer.parseInt(params.get("limit"));
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
                
                if (catIdArr.size()==1){
                    category = articleCategoryService.findOneById(Long.parseLong(params.get("cat_id")));
                } else {
                    category = null;
                }
            } else {
                catIdInteger.add(0);
                params.put("cat_id", "");
            }
        }
        if (catIdArr==null && params.size()>0) {
            params.put("cat_id", "0");
        }
        if (catIdArr==null && params.size()==0) {
            catIdInteger.add(0);
        }

        ArticleFilter articleFilter = new ArticleFilter(params);
        List<ArticleDto> articles = articleService.findAllArticles();
        List<ArticleCategory> categories = articleCategoryService.findAll();

        Pageable pageRequest = PageRequest.of(pageNumber, pageLimit, Sort.Direction.ASC, "id");
        Page<Article> page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), pageRequest);

        model.addAttribute("filtersDef", articleFilter.getFilterDefinition());
        model.addAttribute("filtersDefCat", articleFilter.getFilterDefinitionCat());
        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        model.addAttribute("catIdInteger", catIdInteger);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("page", page);
        return "ui/search";
    }

    @GetMapping("/show_categories")
    public String showSearch(Model model, @RequestParam Map<String, String> params,
                             HttpServletRequest request, HttpServletResponse response,
                             @CookieValue(value = "page_size", required = false) Integer pageSize) {

        return "ui/search";
    }
}
