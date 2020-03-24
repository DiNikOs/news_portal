package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.ArticleLike;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.services.ArticleLikeService;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.CommentService;
import ru.geek.news_portal.services.UserService;

import java.time.LocalDateTime;

/**
 * @Author Farida Gareeva
 * Created 21/03/2020
 * контроллер для вывода страницы со статьей
 * v1.0
 */

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;
    private UserService userService;
    private CommentService commentService;
    private ArticleLikeService articleLikeService;
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

    @GetMapping("/{id}")
    public String showPage(Model model, @PathVariable("id") Long id) {

        model.addAttribute("article", articleService.findById(id));
        model.addAttribute("comments", commentService.findAllCommentByArticle_id(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("articleLikes", articleLikeService.getArticleLikes(id));
        model.addAttribute("articleDislikes", articleLikeService.getArticleDislikes(id));

        return "ui/page";
    }


    @PostMapping("/comment/article_id={article_id}")
    public String addComment(Model model,
                             @PathVariable("article_id") Long article_id,
                             @ModelAttribute("comment") Comment comment) {

        comment.setArticle(articleService.findById(article_id));
        comment.setCreated(LocalDateTime.now());
        comment.setUser(userService.findByUsername("admin"));
        commentService.save(comment);
        return "redirect:/articles/" + article_id;
    }

    @GetMapping("/addLike/{id}")
    public String addArticleLike(Model model,
                                 @PathVariable("id") Long article_id) {
        ArticleLike like = new ArticleLike();
        like.setArticle(articleService.findById(article_id));
        like.setUser(userService.findByUsername("admin"));
        like.setValue(LIKE_VALUE);
        articleLikeService.save(like);
        return "redirect:/articles/" + article_id;
    }

    @GetMapping("/addDislike/{id}")
    public String addArticleDislike(Model model,
                                 @PathVariable("id") Long article_id) {
        ArticleLike like = new ArticleLike();
        like.setArticle(articleService.findById(article_id));
        like.setUser(userService.findByUsername("admin"));
        like.setValue(DISLIKE_VALUE);
        articleLikeService.save(like);
        return "redirect:/articles/" + article_id;
    }

}
