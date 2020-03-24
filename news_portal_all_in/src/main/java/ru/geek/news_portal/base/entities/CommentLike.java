package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 * A table for storage likes and dislikes of comments by authorized users.
 * like = 1 if an user likes a comment
 * like = -1 if an user dislikes a comment
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "comment_likes")
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

}
