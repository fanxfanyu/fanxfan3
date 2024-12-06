package top.fanxfan.project.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * id         bigint      not null auto_increment comment 'id' primary key,
 * username   varchar(64) not null comment '用户名',
 * password   varchar(64) not null comment '密码',
 * mobile     varchar(11) not null comment '手机号',
 * age        int         not null comment '年龄',
 * email      varchar(128) comment '邮箱',
 * loginCount int         not null default 0 comment '登录次数',
 * createTime datetime    not null default current_timestamp comment '创建时间'
 *
 * @author fanxfan
 * @date 2024/2/23 12:22
 */

@Entity
@Table(name = "test.user")
public interface User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    @NotNull
    String password();

    @Column(name = "username")
    @NotNull
    String userName();

    @Nullable
    String email();

    @NotNull
    String mobile();

    int age();

    @Column(name="loginCount")
    int loginCount();
}
