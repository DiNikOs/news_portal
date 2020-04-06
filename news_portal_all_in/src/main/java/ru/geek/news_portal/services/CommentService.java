package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.base.entities.repr.CommentRepr;
import ru.geek.news_portal.base.repo.CommentRepository;

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
 * Updated 04/04/2020
 * сервис для комментариев
 * v1.0
 */

@Service
public class CommentService {

    private EntityManager entityManager;

    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Comment> findAllCommentByArticle_id(Long article_id){
        return commentRepository.findAllCommentByArticle_IdOrderByCreatedDesc(article_id);
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
     * метод возвращает по всем комментариям к выбранной статье детальные данные:
     *      поля сущности + сумму лайков и сумму дизлайков + имя автора
     * Таблица-источник newsportal.comment_details является представлением (view) в базе данных
     */
    public List<CommentRepr> getCommentsWithDetailsByArticle_id(Long article_id) {
        List<CommentRepr> listCommentDetails = new ArrayList<>();
        Query query = entityManager.createNativeQuery("SELECT id, article_id, author, created, text, likes, dislikes\n" +
                "\tFROM newsportal.comment_details where article_id = :article_id");
        query.setParameter("article_id", article_id);
        List<Object[]> listDetails = query.getResultList();
        for (Object[] item : listDetails) {
            CommentRepr details = new CommentRepr((BigInteger) item[0],
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
}
