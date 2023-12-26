package com.my.integration.controller;

import com.my.integration.domain.vo.BookInfoVO;
import com.my.integration.request.BookInfoQueryReq;
import com.my.integration.response.AjaxResult;
import com.my.integration.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@RestController
public class BookListController {

    private static final Logger log = LoggerFactory.getLogger(BookListController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping("/book/listAll")
    public AjaxResult listAllBook(){
        List<BookInfoVO> list = bookService.listAllBooks();
        return  AjaxResult.success(list);
    }

    @PostMapping("/book/queryByName")
    public AjaxResult queryBookByName(@Validated @RequestBody BookInfoQueryReq infoQueryReq){
        log.info("receive the queryByName request of: {}",infoQueryReq.getName());
        BookInfoVO bookInfoVO =  bookService.queryBookByName(infoQueryReq.getName());
        if(Objects.isNull(bookInfoVO)){
            return AjaxResult.success("No such book");
        }
        return AjaxResult.success(bookInfoVO);
    }

}
