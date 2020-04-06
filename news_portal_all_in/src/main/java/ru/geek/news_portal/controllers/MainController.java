/**
 * @Author Created
 * fix Dmitriy Ostrovskiy
 * MainController mapping pages v1.0
 */

package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.base.entities.Tag;
import ru.geek.news_portal.base.specifications.ArticleSpecifications;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleCategoryService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.CommentService;
import ru.geek.news_portal.services.ContactService;
import ru.geek.news_portal.utils.ArticleFilter;
import ru.geek.news_portal.utils.SystemUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private ArticleService articleService;
    private CommentService commentService;
    private ArticleCategoryService articleCategoryService;
    private ContactService contactService;
    //Временное решение до появления сервиса предпочтений пользователя
    private Long RECOMENDED_NEWS = 5L;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String index(Model model, @PathVariable(value = "id", required = false) Long id,
                        HttpServletRequest request,
                        @RequestParam(name = "word", required = false) String word,
                        @RequestParam(name = "pageNumber", required = false) Integer pageNumber) {
        ArticleFilter articleFilter = new ArticleFilter(request);
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        model.addAttribute("articles", articleService.findAllArticles());
        model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
        model.addAttribute("categories", articleCategoryService.findAll());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("filters", articleFilter.getFiltersString());
        return "index";
    }

    @GetMapping("/fragments/news")
    public String fragNews(Model model, @RequestParam(value = "id", required = false) Long id) {
            model.addAttribute("articles", articleService.findAllArticles());
            model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
            model.addAttribute("comment", new Comment());
            model.addAttribute("recomended_news_id", RECOMENDED_NEWS);
            model.addAttribute("categories", articleCategoryService.findAll());
        if (id!=null) {
            model.addAttribute("category", articleCategoryService.findOneById(id));
            model.addAttribute("article", articleService.findById(id));
            model.addAttribute("tags", articleService.findById(id).getTags());
        } else {
            model.addAttribute("category", null);
        }
        return "fragments/news";
    }

    @GetMapping("/fragments/header")
    public String fragHeader(Model model, @RequestParam(value = "id", required = false) Long id) {
        model.addAttribute("articles", articleService.findAllArticles());
        model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
        model.addAttribute("categories", articleCategoryService.findAll());
        return "fragments/header";
    }

    @GetMapping("/fragments/footer")
    public String fragFooter(Model model, @RequestParam(value = "id", required = false) Long id) {
        model.addAttribute("articles", articleService.findAllArticles());
        model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
        model.addAttribute("categories", articleCategoryService.findAll());
        if (id==null){
            model.addAttribute("tags", null);
        } else {
            model.addAttribute("tags", articleService.findById(id).getTags());
        }
        return "fragments/footer";
    }

    @GetMapping("/login")
    public String login() {
        return "ui/login";
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "ui/forgot";
    }

    @GetMapping("/page")
    public String page(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("articles", articleService.findAllArticles());
        return "ui/page";
    }

    @GetMapping("/reset")
    public String reset() {
        return "ui/reset";
    }

    @GetMapping("/single")
    public String single() {
        return "ui/single";
    }

    @GetMapping("/starter")
    public String starter() {
        return "ui/starter";
    }

    @GetMapping("/403")
    public String permission() {
        return "ui/403";
    }

    @GetMapping("/404")
    public String notFound() {
        return "ui/404";
    }

    @GetMapping("/500")
    public String internalServerError() {
        return "ui/500";
    }

    @GetMapping("/503")
    public String serviceUnavailable() {
        return "ui/503";
    }

//  @GetMapping("/admin")
//  @ResponseBody
//  public String admin() {
//    return "Hello";
//  }
}