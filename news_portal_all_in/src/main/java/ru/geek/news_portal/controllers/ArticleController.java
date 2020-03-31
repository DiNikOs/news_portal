package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.ArticleLike;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleLikeService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.CommentService;
import ru.geek.news_portal.services.UserService;

import ru.geek.news_portal.services.*;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author Farida Gareeva
 * Created 21/03/2020
 * контроллер для вывода страницы со статьей
 * v1.0
 */

@Controller
@RequestMapping("/single/articles")
public class ArticleController {

    private ArticleService articleService;
    private UserService userService;
    private CommentService commentService;
    private ArticleLikeService articleLikeService;
    private ArticleCategoryService articleCategoryService;
    private static final Integer LIKE_VALUE = 1;
    private static final Integer DISLIKE_VALUE = -1;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setArticleLikeService(ArticleLikeService articleLikeService) {
        this.articleLikeService = articleLikeService;
    }

    /**
     * Updated by Stanislav Ryzhkov 28/03/2020
     * */
   

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

//     @GetMapping({"/{id}", "/" , ""})
   @GetMapping("/{id}")
    public String showSinglePage(Model model, @PathVariable(value = "id", required = false) Long id) {
        if (id == null) {
            return "ui/404";
        }
        try {
            ArticleDto article = articleService.findArticleDtoById(id);
            model.addAttribute("article", article);
            model.addAttribute("articles", articleService.findAllArticles());
            model.addAttribute("comments", article.getComments());
            model.addAttribute("comment", new Comment());
            model.addAttribute("categories", articleCategoryService.findAll());
            model.addAttribute("articleLikes", article.getLikes());
            model.addAttribute("articleDislikes", articleLikeService.getArticleDislikes(id));
            return "ui/single";
        } catch (Exception e) {
            e.printStackTrace();
            return "ui/404";
        }
//         model.addAttribute("article", articleService.findById(id));
//         model.addAttribute("articles", articleService.findAllArticles());
//         model.addAttribute("comments", commentService.findAllCommentByArticle_id(id));
//         model.addAttribute("categories", articleCategoryService.findAll());
//         model.addAttribute("comment", new Comment());
//         model.addAttribute("articleLikes", articleLikeService.getArticleLikes(id));
//         model.addAttribute("articleDislikes", articleLikeService.getArticleDislikes(id));
//         return "ui/single";

    }

    @GetMapping("/comment/{id}")
    public String showPage(Model model, @PathVariable("id") Long id , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ui/404";
        }
        model.addAttribute("comments", commentService.findAllCommentByArticle_id(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("articleLikes", articleLikeService.getArticleLikes(id));
        model.addAttribute("articleDislikes", articleLikeService.getArticleDislikes(id));
        return "ui/single";
    }

    @PostMapping("/comment/{article_id}")
    public String addComment(Model model,
                             @PathVariable("article_id") Long article_id,
                             @ModelAttribute("comment") Comment comment, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "ui/404";
        }
        comment.setArticle(articleService.findById(article_id));
        comment.setCreated(LocalDateTime.now());
        comment.setUser(userService.findByUsername(request.getRemoteUser()));
        commentService.save(comment);
        return "redirect:/single/articles/" + article_id;
    }

    @GetMapping("/addLike/{id}")
    public String addArticleLike(Model model,
                                 @PathVariable("id") Long article_id, BindingResult bindingResult, User username) {
        ArticleLike like = new ArticleLike();
        like.setArticle(articleService.findById(article_id));
        like.setUser(userService.findByUsername(username.getUsername()));
        like.setValue(LIKE_VALUE);
        articleLikeService.save(like);
        return "redirect:/single/articles/" + article_id;
    }

    @GetMapping("/addDislike/{id}")
    public String addArticleDislike(Model model,
                                 @PathVariable("id") Long article_id, BindingResult bindingResult, User username) {
        ArticleLike like = new ArticleLike();
        like.setArticle(articleService.findById(article_id));
        like.setUser(userService.findByUsername(username.getUsername()));
        like.setValue(DISLIKE_VALUE);
        articleLikeService.save(like);
        return "redirect:/single/articles/" + article_id;
    }

}
