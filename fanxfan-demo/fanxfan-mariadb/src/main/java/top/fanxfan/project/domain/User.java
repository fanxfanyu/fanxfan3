package top.fanxfan.project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author fanxfan
 * @date 2024/1/10 13:50
 */
@Table(name = "user")
@Entity
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
