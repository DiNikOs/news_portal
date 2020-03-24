package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geek.news_portal.base.entities.Picture;

/**
 * @Author Farida Gareeva
 * Created 16/03/2020
 * v1.0
 */
public interface PictureRepository extends JpaRepository<Picture,Long> {
}
