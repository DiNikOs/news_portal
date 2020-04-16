package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.ArticleLike;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.ArticleLikeRepository;
import ru.geek.news_portal.utils.Const;

/**
 * @Author Farida Gareeva
 * Created 21/03/2020
 * сервис для лайков/дислайков статей
 * v1.0
 */

@Service
public class ArticleLikeService {

    private ArticleLikeRepository likeRepository;
    private UserService userService;

    @Autowired
    public ArticleLikeService(ArticleLikeRepository likeRepository, UserService userService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
    }

    public void save(ArticleLike like){
        likeRepository.save(like);
    }

    public Integer getArticleLikes(Long article_id){
        return likeRepository.getArticleLikesOrDislikes(article_id,Const.LIKE_VALUE);
    }

    public Integer getArticleDislikes(Long article_id){
        return likeRepository.getArticleLikesOrDislikes(article_id,Const.DISLIKE_VALUE);
    }

    public void createArticleLike(Long article_id, String username) {
        ArticleLike like = new ArticleLike();
        User user = userService.findByUsername(username);
        like.setArticle(article_id);
        like.setUser(user.getId());
        like.setValue(Const.LIKE_VALUE);
        save(like);
    }

    public void createArticleDislike(Long article_id, String username) {
        ArticleLike like = new ArticleLike();
        User user = userService.findByUsername(username);
        like.setArticle(article_id);
        like.setUser(user.getId());
        like.setValue(Const.DISLIKE_VALUE);
        save(like);
    }
}
