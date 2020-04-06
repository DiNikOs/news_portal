package ru.geek.news_portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Stanislav Ryzhkov
 * Created 05/04/2020
 * Класс для тестирования
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNewArticlesCount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/articles/new")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5));
    }

    @Test
    public void testMostViewedArticlesCount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/articles/most_viewed")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5));
    }

    @Test
    public void testMostViewedArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/articles/most_viewed")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].totalViews").value(1000));
    }
}
