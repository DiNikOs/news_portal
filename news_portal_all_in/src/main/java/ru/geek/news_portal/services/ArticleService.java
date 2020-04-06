package ru.geek.news_portal.services;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.repo.ArticleRepository;
import ru.geek.news_portal.dto.ArticleDto;
import ru.geek.news_portal.exception.NotFoundException;
import ru.geek.news_portal.utils.ListMapper;
import java.util.List;


@Slf4j
@Service
public class ArticleService {
    private static final int NEW_ARTICLES_TOP_COUNT = 5;
    private static final int MOST_VIEWED_ARTICLES_TOP_COUNT = 5;

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
        return mapToDtoList(articleRepository.findAll());
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 05/04/2020
     * Метод, возвращающий 5 новых статей
     */
    public List<ArticleDto> findNewArticles() {
        return mapToDtoList(articleRepository
                .findAllByOrderByPublishedDesc(PageRequest.of(0, NEW_ARTICLES_TOP_COUNT)).getContent());
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 05/04/2020
     * Метод, возвращающий 5 статей
     * с наибольшим количеством просмотров
     */
    public List<ArticleDto> findMostViewedArticles() {
        return mapToDtoList(articleRepository
                .findAllByOrderByTotalViewsDesc(PageRequest.of(0, MOST_VIEWED_ARTICLES_TOP_COUNT)).getContent());
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    /**
     * @author Stanislav Ryzhkov
     * Created 28/03/2020
     * Метод, возвращающий ArticleDto по его id
     * Данный метод вызывается при переходе на страницу статьи,
     * увеличивает количество просмотров на 1 и сохраняет в БД
     */
    public ArticleDto findArticleDtoById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        long views = article.getTotalViews();
        ++views;
        log.info("Total views: {}", views);
        article.setTotalViews(views);
        articleRepository.flush();
        return ArticleDto.fromArticle(article,
                prepareArticleText(article.getText()),
                getMainPictureUrlFromText(article.getText()));
//                article.getPublished(),
//                article.getCategory(),
//                article.getCategoryString(),
//                article.getTotalViews(),
//                article.getLastViewDate(),
//                getMainPictureUrlFromText(article.getText()),
//                article.getStatus(),
//                article.getComments(),
//                article.getLikes(),
//                article.getTags(),
//                article.getRatings()
//        );
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


    /**
     * @author Stanislav Ryzhkov
     * Created 05/04/2020
     * Метод преобразует список Article в список ArticleDto
     */
    private List<ArticleDto> mapToDtoList(List<Article> articles) {
        return ListMapper.mapList(articles, article -> ArticleDto.fromArticle(article,
                prepareArticleText(article.getText()),
                getMainPictureUrlFromText(article.getText())));
    }
  
  
  public Page<Article> findAllByPagingAndFiltering(Specification<Article> specification, Pageable pageable) {
        return articleRepository.findAll(specification, pageable);
    }
}
