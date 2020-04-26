/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * SearchController for Search article Page, and show Categories Page
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
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.utils.ArticleFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class SearchController {
    private ArticleService articleService;
    private ArticleCategoryService articleCategoryService;

    private Long RECOMENDED_NEWS = 5L;
    private final Integer PAGE_LIMIT = 50;

    @Autowired
    public SearchController (ArticleCategoryService articleCategoryService,
                             ArticleService articleService) {
        this.articleCategoryService = articleCategoryService;
        this.articleService = articleService;
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam Map<String, String> params,
                         HttpServletRequest request, HttpServletResponse response,
                         @RequestParam (value = "cat_id", required = false) ArrayList<String> catIdArr,
                         @CookieValue(value = "limit", required = false) Integer pageLimit) {

        Integer pageNumber = 0;
        List<Integer> catIdInteger = new ArrayList<Integer>();

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
        Pageable pageRequest = PageRequest.of(pageNumber, pageLimit, Sort.Direction.ASC, "id");
        Page<Article> page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), pageRequest);

        model.addAttribute("filtersDef", articleFilter.getFilterDefinition());
        model.addAttribute("filtersDefCat", articleFilter.getFilterDefinitionCat());
        model.addAttribute("catIdInteger", catIdInteger);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("page", page);
        return "ui/search";
    }

    @GetMapping({"/category/{id}", "/category"})
    public String categoryShow(Model model,
                               @PathVariable (value = "id", required = false) Long id,
                               @RequestParam Map<String, String> params,
                               HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "limit", required = false) Integer pageLimit) {
        Integer pageNumber = 0;
        boolean categoryOne = false;

        if (params.size()==0) {
            if (id!=null) {
                params.put("cat_id", id.toString());
            }
        }

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
            if (params.get("cat_id").length() == 1 || !params.get("cat_id").contains("")) {
                categoryOne = true;
            }
        }
        List<ArticleDto> articles = articleService.findAllDtoArticles();
        ArticleFilter articleFilter = new ArticleFilter(params);
        Pageable pageRequest = PageRequest.of(pageNumber, pageLimit, Sort.Direction.ASC, "id");
        Page<Article> page = articleService.findAllByPagingAndFiltering(articleFilter.getSpecification(), pageRequest);

        model.addAttribute("filtersDef", articleFilter.getFilterDefinition());
        model.addAttribute("articles", articles);
        model.addAttribute("categoryOne", categoryOne);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageLimit", pageLimit);
        model.addAttribute("page", page);
        return "ui/category";
    }

//    private Map getNumberLimit (Map params, HttpServletResponse response){
//        if (params.containsKey("pageNumber") && params.get("pageNumber")!=null) {
//           params.put("pageNumber", Integer.parseInt(String.valueOf(params.get("pageNumber"))) - 1) ;
//        } else {
//            params.put("pageNumber", "0") ;
//        }
//        if (params.containsKey("limit")) {
//            if (params.get("limit").equals("null") || params.get("limit").equals("0")) {
//                response.addCookie(new Cookie("limit", String.valueOf(50)));
//            }
//        }
//        return params;
//    }
}
