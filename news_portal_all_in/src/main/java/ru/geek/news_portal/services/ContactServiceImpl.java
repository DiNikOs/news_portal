/**
 * @Author Ostrovskiy Dmitriy
 * @Created 21/03/2020
 * ContactService for ContactUs Page
 * @version v1.0
 */

package ru.geek.news_portal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geek.news_portal.base.entities.Contact;
import ru.geek.news_portal.base.entities.Message;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.ContactRepository;
import ru.geek.news_portal.utils.SystemUser;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository=contactRepository;
    }

    @Override
    @Transactional
    public Contact findById(Long id) {
        return contactRepository.findContactById(id);
    }

    @Override
    @Transactional
    public Contact findOneByName(String name) {
        return contactRepository.findContactByName(name);
    }

    @Override
    public boolean isNameExists(String name) {
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        return false;
    }

    @Override
    @Transactional
    public Contact save(SystemUser systemUser) {
        Contact contact = new Contact();
        if (findOneByName(systemUser.getUsername()) != null) {
            throw new RuntimeException("User with username " + systemUser.getUsername() + " is already exist");
        }
        contact.setName(systemUser.getUsername());
        contact.setSubject(systemUser.getFirstName());
        contact.setEmail(systemUser.getEmail());
        contact.setCreated(LocalDateTime.now());
        return contactRepository.save(contact);
    }
}
