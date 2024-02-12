package top.fanxfan.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.fanxfan.project.domain.User;

/**
 * 用户模块
 *
 * @author fanxfan
 * @date 2024/2/12 17:51
 */
@RestController
@RequestMapping("user")
@Tag(name = "用户模块", description = "用户模块")
public class UserController {

    /**
     * 获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取用户信息", description = "获取用户信息")
    @Parameter(name = "id", description = "用户id", required = true, example = "1",in = ParameterIn.PATH)
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(User.builder().id(id).userName("fanxfan").build());
    }

    /**
     * 创建用户
     *
     * @param id       id
     * @param userName 用户名
     * @return 用户信息
     */
    @Operation(summary = "创建用户", description = "创建用户")
    @Parameter(name = "id", description = "用户id", required = true, example = "1",in = ParameterIn.PATH)
    @Parameter(name = "userName", description = "用户名", required = true, example = "fanxfan",in= ParameterIn.QUERY)
    @PostMapping("/{id}")
    public ResponseEntity<User> create(@PathVariable(name = "id") Long id, @RequestParam(defaultValue = "fanxfan", name = "userName") String userName) {
        return ResponseEntity.ok(User.builder().id(id).userName(userName).build());
    }


}
