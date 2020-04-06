package ru.geek.news_portal.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Stanislav Ryzhkov
 * Created 05/04/2020
 * Util-класс, преобразующий список в список
 */
public class ListMapper {

    public static <T1, T2> List<T2> mapList(List<T1> list, Function<? super T1, T2> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
