package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.base.repo.CommentRepository;

import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 19/03/2020
 * сервис для комментариев
 * v1.0
 */

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllCommentByArticle_id(Long article_id){
        return commentRepository.findAllCommentByArticle_IdOrderByCreatedDesc(article_id);
    }

    @Transactional
    public void save(Comment comment){
        commentRepository.save(comment);
    }
}
