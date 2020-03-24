package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 * A table for storage likes and dislikes of comments by authorized users.
 * like = 1 if an user likes a comment
 * like = -1 if an user dislikes a comment
 */

@Entity
@Table(name = "comment_likes")
@Data
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @JsonManagedReference
    @ManyToOne(optional = false)
    Comment comment;

    @JsonManagedReference
    @ManyToOne(optional = false)
    User user;

    @Column(name = "value")
    int value;

    public CommentLike() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Comment getComment() {
//        return comment;
//    }
//
//    public void setComment(Comment comment) {
//        this.comment = comment;
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
