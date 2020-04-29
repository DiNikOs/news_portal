/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * ArticleFilter for SearchController
 * @version v1.10 (30/04/2020)
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
    private Specification<Article> specCat;
    private StringBuilder filterDefinition;
    private StringBuilder filterDefinitionCat;
    private List<Long> listCategory;
    HttpServletRequest request;

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
            filterDefinition.append("&limit=").append(limit);
            filterDefinitionCat.append("&limit=").append(limit);
        }

        if (map.containsKey("art_id") && !map.get("art_id").isEmpty()) {
            Long articleId = Long.parseLong(map.get("art_id"));
            spec = spec.and(ArticleSpecifications.articleId(articleId));
            filterDefinition.append("&art_id=").append(articleId);
        }

        if (map.containsKey("edit") && !map.get("edit").isEmpty()) {
            Boolean editId = Boolean.parseBoolean(map.get("edit"));
            filterDefinition.append("&edit=").append(editId);
        }

        if (map.containsKey("search") && !map.get("search").isEmpty()) {
            filterDefinition.append("&search=").append(map.get("search"));
        }

        if (map.containsKey("delete") && !map.get("delete").isEmpty()) {
            Boolean deleteId = Boolean.parseBoolean(map.get("delete"));
            filterDefinition.append("&delete=").append(deleteId);
        }

        if (map.containsKey("edit_data") && !map.get("edit_data").isEmpty()) {
            Boolean deleteId = Boolean.parseBoolean(map.get("edit_data"));
            filterDefinition.append("&edit_data=").append(deleteId);
        }

        if (map.containsKey("save_data") && !map.get("save_data").isEmpty()) {
            Boolean deleteId = Boolean.parseBoolean(map.get("save_data"));
            filterDefinition.append("&save_data=").append(deleteId);
        }


        if (map.containsKey("cat_id") && !map.get("cat_id").isEmpty()) {
            if (map.get("cat_id")!="0") {
                String[] arrayStr = map.get("cat_id").trim().split(",");
                for (int i = 0; i < arrayStr.length; i++) {
                    specCat = specCat.or(ArticleSpecifications.categoryId(Long.parseLong(arrayStr[i])));
                    filterDefinition.append("&cat_id=").append(Long.valueOf(arrayStr[i]));
                }
            } else {
                specCat = specCat.or(ArticleSpecifications.categoryId(0L));
            }
                spec = spec.and(specCat);
        }
        if (map.containsKey("tag_id") && !map.get("tag_id").isEmpty()) {
            if (map.get("tag_id")!="0") {
                String[] arrayStr = map.get("tag_id").trim().split(",");
                for (int i = 0; i < arrayStr.length; i++) {
                    specCat = specCat.or(ArticleSpecifications.tagsId(Long.parseLong(arrayStr[i])));
                    filterDefinition.append("&tag_id=").append(Long.valueOf(arrayStr[i]));
                }
            } else {
                specCat = specCat.or(ArticleSpecifications.tagsId(0L));
            }
            spec = spec.and(specCat);
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
    public List<Long> getListCategory() {
        return listCategory;
    }

}
