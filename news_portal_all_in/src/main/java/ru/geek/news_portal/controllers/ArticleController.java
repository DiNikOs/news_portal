package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.*;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.*;
import ru.geek.news_portal.utils.ierarhy_comments.Tree;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    private CommentService commentService;
    private ArticleLikeService articleLikeService;
    private ArticleCategoryService articleCategoryService;
    private CommentLikeService commentLikeService;

    //Временное решение до появления сервиса предпочтений пользователя
    private Long RECOMENDED_NEWS = 5L;


    @Autowired
    public ArticleController(ArticleService articleService,
                             CommentService commentService,
                             ArticleLikeService articleLikeService,
                             ArticleCategoryService articleCategoryService,
                             CommentLikeService commentLikeService) {
        this.articleService = articleService;
        this.commentService = commentService;
        this.articleLikeService = articleLikeService;
        this.articleCategoryService = articleCategoryService;
        this.commentLikeService = commentLikeService;
    }

    /**
     * Updated by Stanislav Ryzhkov 28/03/2020
     * */
   

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

   @GetMapping("/{id}")
    public String showSinglePage(Model model, @PathVariable(value = "id", required = false) Long id) {
        if (id == null) {
            return "ui/404";
        }
       try {

            Tree<Long, Comment> tree = commentService.getCommentsTreeByArticle_id(id);

            ArticleDto article = articleService.findArticleDtoById(id);
            model.addAttribute("article", article);
            model.addAttribute("articles", articleService.findAllArticles());
            model.addAttribute("comments", tree.getChildren(null));
            model.addAttribute("tree_comments", tree);
//            model.addAttribute("comments", commentService.findAllCommentByArticle_id(id));
            model.addAttribute("comment", new Comment());
            model.addAttribute("categories", articleCategoryService.findAll());
            model.addAttribute("articleLikes", articleLikeService.getArticleLikes(id));
            model.addAttribute("articleDislikes", articleLikeService.getArticleDislikes(id));
            return "ui/single";
        } catch (Exception e) {
            e.printStackTrace();
            return "ui/404";
        }

    }

    @PostMapping("/comment/{article_id}")
    public String addComment(@PathVariable("article_id") Long article_id,
                             @RequestParam(value = "id_parent", required = false) Long id_parent,
                             @ModelAttribute("comment") Comment comment,
                             BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "ui/404";
        }
        commentService.fillAndSaveComment(comment, article_id, request.getRemoteUser(), id_parent);
        return "redirect:/single/articles/" + article_id;
    }

    @GetMapping("/add/like/{id}")
    public String addArticleLike(@PathVariable("id") Long article_id,
                                 Principal principal) {

        articleLikeService.createArticleLike(article_id, principal.getName());
        return "redirect:/single/articles/" + article_id;
    }

    @GetMapping("/add/dislike/{id}")
    public String addArticleDislike(@PathVariable("id") Long article_id, Principal principal) {

        articleLikeService.createArticleDislike(article_id, principal.getName());
        return "redirect:/single/articles/" + article_id;
    }

    @GetMapping("/comment/add/like/{id}")
    public String addCommentLike(@PathVariable("id") Long comment_id,
                                 Principal principal) {

        Article article = commentService.findCommentById(comment_id).getArticle();
        commentLikeService.createCommentLike(comment_id, principal.getName(), article);
        return "redirect:/single/articles/" + article.getId();
    }

    @GetMapping("/comment/add/dislike/{id}")
    public String addCommentDislike(@PathVariable("id") Long comment_id,
                                 Principal principal) {

        Article article = commentService.findCommentById(comment_id).getArticle();
        commentLikeService.createCommentDislike(comment_id, principal.getName(), article);
        return "redirect:/single/articles/" + article.getId();
    }
}
