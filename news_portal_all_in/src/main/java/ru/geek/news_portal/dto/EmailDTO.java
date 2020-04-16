package ru.geek.news_portal.dto;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.04.2020
 * @link https://github.com/Centnerman
 */

@Data
public class EmailDTO
{
    @NotEmpty(message = "Not Empty!")
    @Size(min = 3, message = "Too short < 4!")
    public String username;

    @NotNull(message = "Not Null!")
    @Size(min = 3, message = "Too short < 3!")
    @Email(message = "Must be Email@xxx.xxx!")
    public String email;

}
