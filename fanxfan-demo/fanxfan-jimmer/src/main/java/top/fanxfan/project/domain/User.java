package top.fanxfan.project.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

/**
 * @author fanxfan
 * @date 2024/2/23 12:22
 */

@Entity
@Table(name = "fanxfan_user")
public interface User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    @Nullable
    String userName();

    @Nullable
    String info();

    @Nullable
    String mobile();

    int sex();
}
