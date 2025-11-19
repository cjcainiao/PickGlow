package com.studentpulse.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询用户信息列表的参数
 */
@Data
public class UserPageListResponse implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户信息列表
     */
    private List<UserInfoResponse> userList;

    /**
     * 总数
     */
    private Long total;

    /**
     * 页码
     */
    private Integer current;

    /**
     * 页大小
     */
    private Integer pageSize;
}
