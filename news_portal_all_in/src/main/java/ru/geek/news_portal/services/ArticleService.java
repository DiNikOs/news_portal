package ru.geek.news_portal.services;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.ArticleCategory;
import ru.geek.news_portal.base.repo.ArticleRepository;
import ru.geek.news_portal.dto.ArticleDto;

import java.util.List;

import java.util.stream.Collectors;

import java.util.Locale;


@Slf4j
@Service
public class ArticleService {

    @Value("${news.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    private ArticleRepository articleRepository;


    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод, возвращающий список ArticleDto
     */
    public List<ArticleDto> findAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(this::fromArticle)
                .collect(Collectors.toList());
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод, возвращающий ArticleDto по его id
     */
    public ArticleDto findArticleDtoById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(IllegalStateException::new);
        return fromArticle(article);
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод, преобразующий Article в ArticleDto
     */
    private ArticleDto fromArticle(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getCreated(),
                article.getTitle(),
                prepareArticleText(article.getText()),
                article.getPublished(),
                article.getCategory(),
                article.getTotalViews(),
                article.getLastViewDate(),
                getMainPictureUrlFromText(article.getText()),
                article.getStatus(),
                article.getComments(),
                article.getLikes(),
                article.getTags(),
                article.getRatings()
        );
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод парсит url главной статьи из первого тега img в тексте статьи
     */
    private String getMainPictureUrlFromText(String text) {
        Document document = Jsoup.parse(text, "", Parser.xmlParser());
        Element img = document.select("img").first();
        transformHtmlTag(img);
        return img.outerHtml();
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод парсит текст статьи и добавляет url к имени картинки исходя из настроек приложения
     * что повышает гибкость и масштабируемость приложения
     */
    private String prepareArticleText(String text) {
        Document document = Jsoup.parse(text, "", Parser.xmlParser());
        Elements elements = document.select("img");
        elements.forEach(this::transformHtmlTag);
        return document.outerHtml();
    }

    private void transformHtmlTag(Element htmlTag) {
        String srcValue = htmlTag.attr("src");
        String updatedSrcValue = String.format("%s:%s/news/images/news/%s", host, port, srcValue);
        htmlTag.attr("src", updatedSrcValue);
    }

}
