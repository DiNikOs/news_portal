package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 */


@Entity
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "text", length = 10000)
  private String text;

  @JsonManagedReference
  @ManyToOne(optional = false)
  private User user;

  @JsonManagedReference
  @ManyToOne
  private Article article;

  @JsonBackReference
  @OneToMany(mappedBy = "comment",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<CommentLike> likes = new ArrayList<>();

  public void addLike(CommentLike like) {
    likes.add(like);
  }

  public void removeLike(CommentLike like) {
    likes.remove(like);
  }

//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public LocalDateTime getCreated() {
//    return created;
//  }
//
//  public void setCreated(LocalDateTime created) {
//    this.created = created;
//  }
//
//  public String getText() {
//    return text;
//  }
//
//  public void setText(String text) {
//    this.text = text;
//  }
//
//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }
//
//  public Article getArticle() {
//    return article;
//  }
//
//  public void setArticle(Article article) {
//    this.article = article;
//  }
//
//  public List<CommentLike> getLikes() {
//    return likes;
//  }
//
//  public void setLikes(List<CommentLike> likes) {
//    this.likes = likes;
//  }
}
