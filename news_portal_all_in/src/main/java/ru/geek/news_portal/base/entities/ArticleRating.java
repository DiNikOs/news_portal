package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
public class ArticleRating {
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
