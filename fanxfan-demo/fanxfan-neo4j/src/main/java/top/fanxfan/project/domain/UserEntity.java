package top.fanxfan.project.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author fanxfan
 * @date 2024/1/8 11:35
 */
@Node
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String mobile;

}
