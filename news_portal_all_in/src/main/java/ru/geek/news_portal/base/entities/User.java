package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @JsonBackReference
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ArticleLike> articleLikes = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CommentLike> commentLikes = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ArticleRating> articleRatings = new ArrayList<>();

    public void addArticleRating(ArticleRating rating) {
        articleRatings.add(rating);
    }

    public void removeArticleRating(ArticleRating rating) {
        articleRatings.remove(rating);
    }

    public void addArticleLike(ArticleLike like) {
        articleLikes.add(like);
    }

    public void removeArticleLike(ArticleLike like) {
        articleLikes.remove(like);
    }

    public void addCommentLike(CommentLike like) {
        commentLikes.add(like);
    }

    public void removeCommentLike(CommentLike like) {
        commentLikes.remove(like);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public List<ArticleLike> getArticleLikes() {
//        return articleLikes;
//    }

//    public void setArticleLikes(List<ArticleLike> articleLikes) {
//        this.articleLikes = articleLikes;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }
//
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }
    //    public List<ArticleRating> getArticleRatings() {
//        return articleRatings;
//    }
//
//    public void setArticleRatings(List<ArticleRating> articleRatings) {
//        this.articleRatings = articleRatings;
//    }

}
