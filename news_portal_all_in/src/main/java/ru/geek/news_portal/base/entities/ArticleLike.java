package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Farida Gareeva
 * Updated 03/04/2020
 * v2.0
 * A table for storage likes and dislikes of articles by authorized users.
 * like = 1 if an user likes an article
 * like = -1 if an user dislikes an article
 * Composite primary key (article, user)
 */

@NoArgsConstructor
@Entity
@Table(name = "article_likes")
@Data
@IdClass(ArticleLike.ArticleLikeId.class)
public class ArticleLike {

    @Id
    @Column(name = "article_id", nullable = false)
    private Long article;

    @Id
    @Column(name = "user_id", nullable = false)
    private Long user;

    @Column(name = "value")
    private int value;

    @EqualsAndHashCode
    @Access(value = AccessType.FIELD)
    @Setter
    public static class ArticleLikeId implements Serializable {
        private Long article;
        private Long user;
    }
}
