/**
 * @Author Ostrovskiy Dmitriy
 * @Created 31/03/2020
 * Entity for ContactUs Page
 * @version v1.0
 */


package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private LocalDateTime created;

    @JsonBackReference
    @OneToMany(mappedBy = "contact",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Message> messages;

    public void addMessage (Message message) {
        if (subject==this.subject||messages.size()==0){
            messages.add(message);
        }
    }

    public void deleteMessage (Message message) {
        messages.remove(message);
    }

    public LocalDateTime getCreated() {
        if (created == null) {
            created = LocalDateTime.now();
        }
        return created;
    }
}
