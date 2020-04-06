/**
 * @Author Ostrovskiy Dmitriy
 * @Created 21/03/2020
 * TagsService for use tags
 * @version v1.0
 */

package ru.geek.news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.base.entities.Tag;
import ru.geek.news_portal.base.repo.TagRepository;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {
    private TagRepository tagRepository;

    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public Tag findById(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public String findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Tag findTagByName(String name) {
        return tagRepository.findTagByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag save(String name) {
        if (tagRepository.findByName(name)==null){
            return null;
        }
        Tag tag = new Tag();
        tag.setName(name);
        return tagRepository.save(tag);
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}
