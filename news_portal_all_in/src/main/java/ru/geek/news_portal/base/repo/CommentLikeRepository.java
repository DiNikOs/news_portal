package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geek.news_portal.base.entities.CommentLike;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 */
public interface CommentLikeRepository extends JpaRepository<CommentLike,CommentLike.CommentLikeId> {

    @Query("select sum(a.value) from CommentLike a where a.comment = :comment_id and a.value = :value")
    public Integer getCommentLikesOrDislikes(@Param("comment_id") Long comment_id, @Param("value") Integer value);

}
