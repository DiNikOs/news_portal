package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "articles")
public class Article {

    public enum Status {EDIT, PUBLISHED, ARCHIVE}

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

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
  private Status status;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          cascade = CascadeType.ALL
  )
  private List<Comment> comments;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          cascade = CascadeType.ALL
  )
  private List<ArticleLike> likes;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "articles_tags",
          joinColumns = @JoinColumn(name = "article_id"),
          inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          cascade = CascadeType.ALL
  )
  private List<ArticleRating> ratings;

  public LocalDateTime getCreated() {
    if (created == null) {
        created = LocalDateTime.now();
    }
    return created;
  }

  public String getTitle() {
    if (title == null) {
      title = "Title_default";
    }
    return title;
  }

  public String getCategoryString() {
    String categoryString;
    if (category == null) {
      categoryString = "Category_default";
      return categoryString;
    }
    return category.getName();
  }
}
