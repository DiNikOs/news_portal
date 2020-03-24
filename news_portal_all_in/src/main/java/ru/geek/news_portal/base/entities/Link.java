package ru.geek.news_portal.base.entities;//package ru.geek.news_portal.newsportal.entities;

import javax.persistence.*;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    public Link() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
}
