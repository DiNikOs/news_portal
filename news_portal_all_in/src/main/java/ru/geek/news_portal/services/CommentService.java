package ru.geek.news_portal.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.base.repo.CommentRepository;
import ru.geek.news_portal.dto.CommentDto;
import ru.geek.news_portal.utils.ierarhy_comments.Tree;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author Farida Gareeva
 * Created 19/03/2020
 * Updated 11/04/2020
 * сервис для комментариев
 * v1.3
 */

@Service
public class CommentService {

    private EntityManager entityManager;

    private CommentRepository commentRepository;

    private ArticleService articleService;

    private UserService userService;

    public CommentService(EntityManager entityManager,
                          CommentRepository commentRepository,
                          ArticleService articleService,
                          UserService userService) {
        this.entityManager = entityManager;
        this.commentRepository = commentRepository;
        this.articleService = articleService;
        this.userService = userService;
    }

    public List<Comment> findAllCommentByArticle_id(Long article_id){
        return commentRepository.findAllCommentByArticle_IdOrderByCreatedDesc(article_id);
    }

    /**
     * @Author Farida Gareeva
     * Created 11/04/2020
     * v1.0
     * метод используется для заполнения иерархического дерева комментариев.
     * Сортировка по возрастанию id комментария, чтобы комментарии-родители
     * были в списке гарантированно раньше своих потомков.
     */
    public List<Comment> findCommentsByArticle_IdOrderById(Long article_id){
        return commentRepository.findCommentsByArticle_IdOrderById(article_id);
    }

    @Transactional
    public void save(Comment comment){
        commentRepository.save(comment);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * @Author Farida Gareeva
     * Created 04/04/2020
     *
     * В данный момент метод не используется.
     * Создавался с целью оптимизации обращения к БД для получения
     * итоговых значений лайков и дизлайков к комментариям статей.
     * Для оптимизации в БД создана view comment_details
     *
     * метод возвращает по всем комментариям к выбранной статье список детальных данных CommentDto,
     * содержащих следующие данные:
     *      поля сущности + сумму лайков и сумму дизлайков + имя автора.
     */
    public List<CommentDto> getCommentsWithDetailsByArticle_id(Long article_id) {
        List<CommentDto> listCommentDetails = new ArrayList<>();
        Query query = entityManager.createNativeQuery("SELECT id, article_id, author, created, text, likes, dislikes\n" +
                "\tFROM newsportal.comment_details where article_id = :article_id");
        query.setParameter("article_id", article_id);
        List<Object[]> listDetails = query.getResultList();
        for (Object[] item : listDetails) {
            CommentDto details = new CommentDto((BigInteger) item[0],
                    (BigInteger) item[1],
                    (String) item[2],
                    (Timestamp) item[3],
                    (String) item[4],
                    (BigInteger) item[5],
                    (BigInteger) item[6]);
            listCommentDetails.add(details);
        }
        return listCommentDetails;
    }

    public void fillAndSaveComment(Comment comment, Long article_id, String username, Long id_parent) {
        comment.setArticle(articleService.findById(article_id));
        comment.setUser(userService.findByUsername(username));
        comment.setId_parent(id_parent);
        save(comment);
    }

    /**
     * @Author Farida Gareeva
     * Created 11/04/2020
     * Метод, возвращающий дерево комментариев.
     * В качестве корневого узла используется вспомогательный нод (null,null).
     * Поэтому при определении размера дерева в представлении вычитается единица.
     */
    public Tree<Long, Comment> getCommentsTreeByArticle_id(Long id) {
        Tree<Long, Comment> tree = new Tree<>(null, null);
        List<Comment> comments = findCommentsByArticle_IdOrderById(id);
        for (Comment comm: comments) {
            tree.addChild(comm.getId_parent(),comm.getId(),comm);
        }
        return tree;
    }

    /**
     * @Author Farida Gareeva
     * Created 11/04/2020
     * Метод, возвращающий список дочерних комментариев ближайшего родства
     * (только детей без внуков и последующих потомков)
     */
    public ArrayList<Comment> getChildren(Tree tree, Long comment_id){
        return tree.getChildren(comment_id);
    }
}
