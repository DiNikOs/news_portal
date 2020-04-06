/**
 * @Author Ostrovskiy Dmitriy
 * @Created 21/03/2020
 * Interface TagsService for use tags
 * @version v1.0
 */

package ru.geek.news_portal.services;


import ru.geek.news_portal.base.entities.Tag;

import java.util.List;

public interface TagsService {

    Tag findById(Long id);
    String findByName(String name);
    Tag findTagByName(String name);
    List<Tag> findAll();

    Tag save(String name);
    void delete(Long id);

}
