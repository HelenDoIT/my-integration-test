package com.my.integration.service;

import com.my.integration.domain.vo.BookInfoVO;

import java.util.List;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
public interface IBookService {

    List<BookInfoVO> listAllBooks();

    BookInfoVO queryBookByName(String name);
}
