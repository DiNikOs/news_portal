package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geek.news_portal.base.entities.Tag;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
}
