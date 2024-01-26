package top.fanxfan.project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * 用户
 *
 * @author fanxfan
 * @date 2024/1/19 13:19
 */
@Entity
@Table(name = "fanxfan_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private int sex;

    private String mobile;

    @Column(columnDefinition = "TEXT")
    private String info;
}
