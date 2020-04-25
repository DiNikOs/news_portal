package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.ArticleRating;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.ArticleRatingRepository;

/**
 * @Author Farida Gareeva
 * Created 21/04/2020
 * сервис для оценок статей (рейтинга статей)
 * v1.0
 */

@Service
public class ArticleRatingService {

    private UserService userService;
    private ArticleRatingRepository repository;

    @Autowired
    public ArticleRatingService(UserService userService, ArticleRatingRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    public void addArticleRating(Long article_id, String username, int value) {
        ArticleRating rating = new ArticleRating();
        rating.setArticle(article_id);
        User user = userService.findByUsername(username);
        rating.setUser(user.getId());
        rating.setValue(value);
        repository.save(rating);
    }

    public Integer getValueByArticle_idAndUsername(Long article_id, String username) {
        ArticleRating res = repository.getOneByArticleAndUser(article_id, userService.findByUsername(username).getId());
        int value = 0;
        if (res != null) {
            value = res.getValue();
        }
        return value;
    }

    public float getAverageValueOfArticle(Long id){
        return repository.getAverageValueOfArticle(id);
    }
}
