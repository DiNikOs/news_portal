package ru.geek.news_portal.dto;

import java.util.ArrayList;
import java.util.List;

public class PageLimitDto {
    List<Integer> pageList = new ArrayList<>();

    public PageLimitDto() {
    }

    public List<Integer> getList(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(5);
        pageList.add(10);
        pageList.add(50);
        pageList.add(100);
        return  pageList;
    }
}
