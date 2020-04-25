package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 * A table for storage values of articles by authorized users.
 * value from 1 to 5
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "article_rating")
@IdClass(ArticleRating.ArticleRatingId.class)
public class ArticleRating {
    @Id
    @Column(name = "article_id", nullable = false)
    private Long article;

    @Id
    @Column(name = "user_id", nullable = false)
    private Long user;

    @Column(name = "value")
    int value;

    @EqualsAndHashCode
    @Access(value = AccessType.FIELD)
    @Setter
    public static class ArticleRatingId implements Serializable {
        private Long article;
        private Long user;
    }
}
