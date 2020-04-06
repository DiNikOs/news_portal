package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.ArticleLike;
import ru.geek.news_portal.base.repo.ArticleLikeRepository;

/**
 * @Author Farida Gareeva
 * Created 21/03/2020
 * сервис для лайков/дислайков статей
 * v1.0
 */

@Service
public class ArticleLikeService {

    private ArticleLikeRepository likeRepository;

    @Autowired
    public void setArticleLikeService(ArticleLikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    public void save(ArticleLike like){
        likeRepository.save(like);
    }

    public Integer getArticleLikes(Long article_id){
        return likeRepository.getArticleLikesOrDislikes(article_id,1);
    }

    public Integer getArticleDislikes(Long article_id){
        return likeRepository.getArticleLikesOrDislikes(article_id,-1);
    }

}
