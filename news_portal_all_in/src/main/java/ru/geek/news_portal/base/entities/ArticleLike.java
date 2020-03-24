package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 * A table for storage likes and dislikes of articles by authorized users.
 * like = 1 if an user likes an article
 * like = -1 if an user dislikes an article
 */

@NoArgsConstructor
@Entity
@Table(name = "article_likes")
@Data
public class ArticleLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @JsonManagedReference
    @ManyToOne(optional = false)
    Article article;

    @JsonManagedReference
    @ManyToOne(optional = false)
    User user;

    @Column(name = "value")
    int value;
}
