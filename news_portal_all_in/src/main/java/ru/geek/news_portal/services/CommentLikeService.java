package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.CommentLike;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.CommentLikeRepository;
import ru.geek.news_portal.utils.Const;

/**
 * @Author Farida Gareeva
 * Created 03/04/2020
 * сервис для лайков комментариев
 * v1.0
 */

@Service(value = "commentLikeService")
public class CommentLikeService {

    private CommentLikeRepository repository;
    private UserService userService;

    @Autowired
    public CommentLikeService(CommentLikeRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }


    public Integer getLikes(Long comment_id){
        return repository.getCommentLikesOrDislikes(comment_id,Const.LIKE_VALUE);
    }

    public Integer getDislikes(Long comment_id){
        return repository.getCommentLikesOrDislikes(comment_id,Const.DISLIKE_VALUE);
    }

    public void save(CommentLike like){
        repository.save(like);
    }

    public void createCommentLike(Long comment_id, String username,Article article) {
        CommentLike like = new CommentLike();
        User user = userService.findByUsername(username);
        like.setComment(comment_id);
        like.setUser(user.getId());
        like.setArticle(article);
        like.setValue(Const.LIKE_VALUE);
        save(like);
    }

    public void createCommentDislike(Long comment_id, String username,Article article){
        CommentLike like = new CommentLike();
        User user = userService.findByUsername(username);
        like.setComment(comment_id);
        like.setUser(user.getId());
        like.setArticle(article);
        like.setValue(Const.DISLIKE_VALUE);
        save(like);
    }
}
