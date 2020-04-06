package ru.geek.news_portal.base.entities.repr;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class CommentRepr {

    private BigInteger id;

    private BigInteger article_id;

    private String author;

    private Timestamp created;

    private String text;

    private BigInteger likes;

    private BigInteger dislikes;

    public CommentRepr(BigInteger id, BigInteger article_id, String author, Timestamp created, String text, BigInteger likes, BigInteger dislikes) {
        this.id = id;
        this.article_id = article_id;
        this.author = author;
        this.created = created;
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
