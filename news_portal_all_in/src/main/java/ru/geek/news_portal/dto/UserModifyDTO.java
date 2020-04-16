package ru.geek.news_portal.dto;

import lombok.Data;
import ru.geek.news_portal.base.entities.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.04.2020
 * @link https://github.com/Centnerman
 */

@Data
public class UserModifyDTO {

    @NotNull(message = "Not Null!")
    private Long id;

    @NotNull(message = "Not Null!")
    private String username;

    @NotNull(message = "Not Null!")
    private String password;

    @NotNull(message = "Not Null!")
    private String firstName;

    @NotNull(message = "Not Null!")
    private String lastName;

    @NotNull(message = "Not Null!")
    private String email;

    private Collection<Role> roles;
}
