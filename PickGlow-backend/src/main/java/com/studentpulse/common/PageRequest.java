package com.studentpulse.common;

import lombok.Data;

@Data
public class PageRequest {


    private int current = 1; //当前页号

    private int pageSize = 10; //页面大小

    private String sortField; //排序字段

    private String sortOrder = "descend"; //排序顺序

}
