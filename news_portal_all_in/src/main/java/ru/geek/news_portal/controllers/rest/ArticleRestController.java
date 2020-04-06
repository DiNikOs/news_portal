package ru.geek.news_portal.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.services.ArticleService;

import java.util.List;

/**
 * @author Stanislav Ryzhkov
 * Created 05/04/2020
 * Rest-controller для статей
 */
@RestController
@RequestMapping(value = "api/articles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping("new")
    public List<ArticleDto> getNewArticles() {
        return articleService.findNewArticles();
    }

    @GetMapping("most_viewed")
    public List<ArticleDto> getMostViewedArticles() {
        return articleService.findMostViewedArticles();
    }
}
