package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 * A table for storage values of articles by authorized users.
 * value from 1 to 5
 */

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

    public ArticleRating() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
}
