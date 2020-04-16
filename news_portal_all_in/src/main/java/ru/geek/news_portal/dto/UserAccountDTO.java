package ru.geek.news_portal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geek.news_portal.base.entities.*;
import ru.geek.news_portal.base.repo.UserRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 07.04.2020
 * @link https://github.com/Centnerman
 */

@Data
public class UserAccountDTO {

    @NotNull(message = "Not Null!")
    private String username;

    @NotNull(message = "Not Null!")
    private String firstName;

    @NotNull(message = "Not Null!")
    private String lastName;

    @NotNull(message = "Not Null!")
    private String email;

    private List<ArticleLike> articleLikes;

    private List<Comment> comments;

    private List<CommentLike> commentLikes;

    private List<ArticleRating> articleRatings;

}
