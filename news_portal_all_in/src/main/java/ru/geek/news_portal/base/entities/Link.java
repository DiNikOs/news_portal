package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

}
