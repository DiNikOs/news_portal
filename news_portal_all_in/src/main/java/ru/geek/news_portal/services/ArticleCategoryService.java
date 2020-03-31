/**
 * @Author Dmitriy Ostrovskiy
 *
 * ArticleCategory Service
 * @version v1.0
 */

package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.base.repo.ArticleCategoryRepository;

import java.util.List;

@Service
public class ArticleCategoryService {

    ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    public void setArticleCategoryRepository(ArticleCategoryRepository articleCategoryRepository) {
        this.articleCategoryRepository = articleCategoryRepository;
    }

    public List<ArticleCategory> findAll() {
        return (List<ArticleCategory>)articleCategoryRepository.findAll();
    }

    public ArticleCategory findOneById(Long id) {
        return articleCategoryRepository.getOne(id);
    }
}
