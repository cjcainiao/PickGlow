# SQL编写文件

# 创建数据库
create database if not exists PickGlow;

use PickGlow;

# 用户基本信息表
create table if not exists user
(
    id          bigint auto_increment primary key      not null comment 'id',
    user_name   varchar(256) comment '用户名',
    password    varchar(1024)                          not null comment '密码',
    avatar      varchar(1024) comment '头像',
    profile     varchar(512) comment '用户简介',
    role        varchar(256) default 'user' comment '用户角色',
    email       varchar(128) comment '邮箱',
    phone       varchar(32) comment '手机号码',
    status      int          default 1 comment '账号是否正常',
    create_time datetime     default current_timestamp not null comment '创建时间',
    update_time datetime     default current_timestamp not null comment '更新时间',
    unique idx_userName (user_name) comment '用户名索引'
) comment '用户基本信息表' collate = utf8mb4_unicode_ci;