package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geek.news_portal.base.repo.CommentLikeRepository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v.0
 * A table for storage likes and dislikes of comments by authorized users.
 * like = 1 if an user likes a comment
 * like = -1 if an user dislikes a comment
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "comment_likes")
@IdClass(CommentLike.CommentLikeId.class)
public class CommentLike {

    @Id
    @Column(name = "comment_id", nullable = false)
    Long comment;

    @Id
    @Column(name = "user_id", nullable = false)
    Long user;

    @Column(name = "value")
    int value;

    @Setter
    @EqualsAndHashCode
    @Access(value = AccessType.FIELD)
    public static class CommentLikeId implements Serializable {
        Long comment;
        Long user;
    }

}
