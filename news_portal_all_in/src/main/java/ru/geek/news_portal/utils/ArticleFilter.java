/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * ArticleFilter for SearchController
 * @version v1.0
 */

package ru.geek.news_portal.utils;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.specifications.ArticleSpecifications;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Getter
public class ArticleFilter {

    private Specification<Article> spec;
    private StringBuilder filterDefinition;
    private StringBuilder filterDefinitionCat;
    private Specification<Article> specCat;
    private List<Long> listCategory;
    private List<String> listCat;

    int iter2 = 0;
    HttpServletRequest request;

    public List<Long> getListCategory() {
        return listCategory;
    }

    public ArticleFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.specCat = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        this.filterDefinitionCat = new StringBuilder();

        if (map.containsKey("word") && !map.get("word").isEmpty()) {
            String word = map.get("word");
            spec = spec.and(ArticleSpecifications.titleContains(word));
            filterDefinition.append("&word=").append(word);
            filterDefinitionCat.append("&word=").append(word);
        }
        if (map.containsKey("limit") && !map.get("limit").isEmpty()) {
            Integer limit = Integer.parseInt(map.get("limit"));
//            spec = spec.and(ArticleSpecifications.limitNavTab(limit));
            filterDefinition.append("&limit=").append(limit);
            filterDefinitionCat.append("&limit=").append(limit);
        }

        if (map.containsKey("cat_id") && !map.get("cat_id").isEmpty()) {
            if (map.get("cat_id")!="0") {
                String[] arrayStr = map.get("cat_id").trim().split(",");
                for (int i = 0; i < arrayStr.length; i++) {
                    specCat = specCat.or(ArticleSpecifications.categoryId(Long.valueOf(arrayStr[i])));
                    filterDefinition.append("&cat_id=").append(Long.valueOf(arrayStr[i]));
                }
            } else {
                specCat = specCat.or(ArticleSpecifications.categoryId(0L));
            }
                spec = spec.and(specCat);
        }
//        if (map.containsKey("pageNumber") && !map.get("pageNumber").isEmpty()) {
//            Integer pageNumber = Integer.parseInt(map.get("pageNumber"));
//            filterDefinition.append("&pageNumber=").append(pageNumber);
//        }
        if (map.containsKey("pageLimit") && !map.get("pageLimit").isEmpty()) {
            Integer pageLimit = Integer.parseInt(map.get("pageLimit"));
            filterDefinition.append("&pageLimit=").append(pageLimit);
            filterDefinitionCat.append("&pageLimit=").append(pageLimit);
        }
    }

    public Specification<Article> getSpecification() {
        return spec;
    }

    public Specification<Article> getSpecCat() {
        return specCat;
    }

    public void setListCat(List<String> stringList){
        listCategory = new ArrayList<>();
        for (int i = 0; i <stringList.size() ; i++) {
            listCategory.add(Long.parseLong(stringList.get(i)));
        }
    }

    public List<Long> getListCat (){
        return listCategory;
    }

    public StringBuilder getFilterDefinition() {
        return filterDefinition;
    }
    public StringBuilder getFilterDefinitionCat() {
        return filterDefinitionCat;
    }


}
