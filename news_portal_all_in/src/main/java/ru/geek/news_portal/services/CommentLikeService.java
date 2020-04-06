package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.CommentLike;
import ru.geek.news_portal.base.repo.CommentLikeRepository;

/**
 * @Author Farida Gareeva
 * Created 03/04/2020
 * сервис для лайков комментариев
 * v1.0
 */

@Service(value = "commentLikeService")
public class CommentLikeService {

    private CommentLikeRepository repository;

    @Autowired
    public void setRepository(CommentLikeRepository repository){
        this.repository = repository;
    }

    public Integer getLikes(Long comment_id){
        return repository.getCommentLikesOrDislikes(comment_id,1);
    }

    public Integer getDislikes(Long comment_id){
        return repository.getCommentLikesOrDislikes(comment_id,-1);
    }

    public void save(CommentLike like){
        repository.save(like);
    }

}
