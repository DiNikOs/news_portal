package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "articles")
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "title", unique = true)
  private String title;

  @Column(name = "text", length = 10000)
  private String text;

  @Column(name = "published")
  private LocalDateTime published;

  @JsonManagedReference
  @ManyToOne(optional = false)
  private ArticleCategory category;

  @Column(name = "total_views")
  private Long totalViews;

  @Column(name = "last_view_date")
  private LocalDateTime lastViewDate;

  @Column(name = "main_picture_url")
  private String mainPictureUrl;

  @JsonManagedReference
  @ManyToOne(optional = false)
  private ArticleCategory status;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Comment> comments = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<ArticleLike> likes = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "articles_tags",
          joinColumns = @JoinColumn(name = "article_id"),
          inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<ArticleRating> ratings = new ArrayList<>();


  public void addLike(ArticleLike like) {
    likes.add(like);
  }

  public void removeLike(ArticleLike like) {
    likes.remove(like);
  }

  public void addComment(Comment comment) {
    comments.add(comment);
  }

  public void removeComment(Comment comment) {
    comments.remove(comment);
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

//  public List<Tag> getTags() {
//    return tags;
//  }
//
//  public void setTags(List<Tag> tags) {
//    this.tags = tags;
//  }
//
//  public List<ArticleRating> getRatings() {
//    return ratings;
//  }
//
//  public void setRatings(List<ArticleRating> ratings) {
//    this.ratings = ratings;
//  }
//
//  public ArticleCategory getCategory() {
//    return category;
//  }
//
//  public void setCategory(ArticleCategory category) {
//    this.category = category;
//  }
//
//  public LocalDateTime getPublished() {
//    return published;
//  }
//
//  public void setPublished(LocalDateTime published) {
//    this.published = published;
//  }
//
//  public Long getTotalViews() {
//    return totalViews;
//  }
//
//  public void setTotalViews(Long totalViews) {
//    this.totalViews = totalViews;
//  }
//
//  public LocalDateTime getLastViewDate() {
//    return lastViewDate;
//  }
//
//  public void setLastViewDate(LocalDateTime lastViewDate) {
//    this.lastViewDate = lastViewDate;
//  }
//
//  public String getMainPictureUrl() {
//    return mainPictureUrl;
//  }
//
//  public void setMainPictureUrl(String mainPictureUrl) {
//    this.mainPictureUrl = mainPictureUrl;
//  }
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }

//  public String getTitle() {
//    return title;
//  }
//
//  public void setTitle(String title) {
//    this.title = title;
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
//  public List<ArticleLike> getLikes() {
//    return likes;
//  }
//
//  public void setLikes(List<ArticleLike> likes) {
//    this.likes = likes;
//  }
//
//  public List<Comment> getComments() {
//    return comments;
//  }
//
//  public void setComments(List<Comment> comments) {
//    this.comments = comments;
//  }
}
