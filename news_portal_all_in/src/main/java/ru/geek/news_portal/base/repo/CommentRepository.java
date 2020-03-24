package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geek.news_portal.base.entities.Comment;

import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 19/03/2020
 * v1.0
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

//    public List<Comment> findAllCommentByArticle_id(Long article_id);
//    public List<Comment> findAllCommentByArticle_idSOrderByCreatedDesc(Long article_id);
    public List<Comment> findAllCommentByArticle_IdOrderByCreatedDesc(Long article_id);


}
