package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.entities.User;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);
    User findOneById(Long id);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<User> findUserByUsername(String username);

}
