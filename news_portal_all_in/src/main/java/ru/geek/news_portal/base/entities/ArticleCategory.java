package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "article_categories")
public class ArticleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Article> articles;

}
