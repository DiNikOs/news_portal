/**
 * @Author Ostrovskiy Dmitriy
 * @Created 21/03/2020
 * Interface ContactService for ContactUs Page
 * @version v1.0
 */

package ru.geek.news_portal.services;

import org.springframework.transaction.annotation.Transactional;
import ru.geek.news_portal.base.entities.Contact;
import ru.geek.news_portal.utils.SystemUser;

public interface ContactService {
    Contact findById(Long id);

    Contact findOneByName(String name);

    boolean isNameExists(String name);
    boolean isEmailExists(String email);

    Contact save(SystemUser systemUser);

}
