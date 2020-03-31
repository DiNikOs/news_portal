/**
 * @Author Ostrovskiy Dmitriy
 * @Created 31/03/2020
 * Repository for ContactUs Page
 * @version v1.0
 */

package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.Contact;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findContactById(Long id);
    Contact findContactByName(String name);

//    boolean existsByName(String name);
//    boolean existsByEmail(String email);

}
