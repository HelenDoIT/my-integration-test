package com.my.integration.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@Getter@Setter@ToString
public class BookInfoVO implements Serializable {

    private Long bookId;
    private String name;
    private String author;
    private int inventory;

    public BookInfoVO() { }

    public BookInfoVO(Long bookId, String name, String author, int inventory) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.inventory = inventory;
    }
}
