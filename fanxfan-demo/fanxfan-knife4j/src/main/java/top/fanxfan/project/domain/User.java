package top.fanxfan.project.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author fanxfan
 * @date 2024/2/12 17:34
 */
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Schema(name = "id", description = "用户ID")
    private Long id;

    /**
     * 用户名
     */
    @Schema(name = "userName", description = "用户名", nullable = true, requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
}