package top.fanxfan.project.controller;

import jakarta.annotation.Resource;
import org.babyfish.jimmer.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.service.UserService;

import java.util.Optional;

/**
 * @author fanxfan
 * @date 2024/2/23 13:02
 */
@RestController
@RequestMapping("/user")
// @RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取指定id用户
     *
     * @param id id
     * @return {@link  User}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.of(Optional.ofNullable(user));
    }

    /**
     * 分页获取
     *
     * @param username 用户名
     * @param mobile   手机号
     * @param page     当前页
     * @param size     每页大小
     * @return {@link Page}
     */
    @GetMapping("/list")
    public ResponseEntity<Page<User>> list(String username, String mobile, int page, int size) {
        Page<User> users = userService.getUsers(username, mobile, page, size);
        return ResponseEntity.ok(users);
    }

}
