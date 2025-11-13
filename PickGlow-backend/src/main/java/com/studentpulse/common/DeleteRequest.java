package com.studentpulse.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRequest implements Serializable {


    private Long id; //删除id

    private static final long serialVersionUID = 1L;
}
