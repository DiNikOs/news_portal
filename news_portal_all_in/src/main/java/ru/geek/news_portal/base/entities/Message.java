/**
 * @Author Ostrovskiy Dmitriy
 * @Created 31/03/2020
 * Entity for ContactUs Page
 * @version v1.0
 */

package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "text", length = 10000)
    private String text;

    @JsonManagedReference
    @ManyToOne
    private Contact contact;

}
