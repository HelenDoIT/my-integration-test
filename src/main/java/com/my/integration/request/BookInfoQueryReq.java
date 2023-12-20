package com.my.integration.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@Getter@Setter
public class BookInfoQueryReq implements Serializable {

    private String name;

}
