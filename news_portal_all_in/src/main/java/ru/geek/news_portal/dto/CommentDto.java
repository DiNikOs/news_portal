package ru.geek.news_portal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author Farida Gareeva
 * Created 04/04/2020
 * v1.0
 * В данный момент класс не используется.
 * Создавался с целью оптимизации обращения к БД для получения
 * итоговых значений лайков и дизлайков к комментариям статей.
 * Для оптимизации в БД создана view comment_details
 * Для получения данных из БД используется метод
 * CommentService.getCommentsWithDetailsByArticle_id(Long article_id)
 */

@Getter
@Setter
public class CommentDto {

    private BigInteger id;

    private BigInteger article_id;

    private String author;

    private Timestamp created;

    private String text;

    private BigInteger likes;

    private BigInteger dislikes;

    public CommentDto(BigInteger id, BigInteger article_id, String author, Timestamp created, String text, BigInteger likes, BigInteger dislikes) {
        this.id = id;
        this.article_id = article_id;
        this.author = author;
        this.created = created;
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
