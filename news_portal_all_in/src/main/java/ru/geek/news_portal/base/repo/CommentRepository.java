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

    public List<Comment> findAllCommentByArticle_IdOrderByCreatedDesc(Long article_id);

    /**
     * @Author Farida Gareeva
     * Created 11/04/2020
     * v1.0
     * метод используется для заполнения иерархического дерева комментариев.
     * Сортировка по возрастанию id комментария, чтобы комментарии-родители
     * были в списке гарантированно раньше своих потомков.
     */
    public List<Comment> findCommentsByArticle_IdOrderById(Long article_id);
}
