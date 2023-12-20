package com.my.integration.service.impl;

import com.my.integration.domain.vo.BookInfoVO;
import com.my.integration.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@Service
public class BookServiceImpl implements IBookService {

    @Override
    public List<BookInfoVO> listAllBooks() {
        // assume there is query DB here
        BookInfoVO bookInfoVO = new BookInfoVO(2L, "Clean Code", "Robert C", 5);
        List<BookInfoVO> list = Arrays.asList(bookInfoVO);
        return list;
    }

    @Override
    public BookInfoVO queryBookByName(String name) {
        // assume there is query DB here
        if("Clean Code".equals(name)){
            return new BookInfoVO(2L, "Clean Code", "Robert C", 5);
        }else if(name.startsWith("Java")){
            return new BookInfoVO(5L, "Java **", "Author**", 10);
        }
        return null;
    }
}
