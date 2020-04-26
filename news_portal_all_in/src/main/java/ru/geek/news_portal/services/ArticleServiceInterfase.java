/**
 * @author Ostrovskiy Dmitriy
 * @created 24.04.2020
 * ArticleServiceInterfase
 * @version v1.0
 */

package ru.geek.news_portal.services;

import ru.geek.news_portal.base.entities.Article;

public interface ArticleServiceInterfase {
    Article findById (Long id);
    void save (Article article);
    void delete (Article article);
}
