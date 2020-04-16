package ru.geek.news_portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geek.news_portal.utils.validation.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 06.04.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
@FieldMatch(first = "newPassword", second = "matchingPassword", message = "The password fields must match")
public class NewPasswordDTO {

    @NotNull(message = "Not Null!")
    @Size(min = 3, message = "Too short <4!")
    private String newPassword;

    @NotNull(message = "Not Null!")
    @Size(min = 3, message = "Too short <4!")
    private String matchingPassword;

}
