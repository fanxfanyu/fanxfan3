package top.fanxfan.project.controller;

import jakarta.annotation.Resource;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.domain.UserFetcher;
import top.fanxfan.project.repository.UserRepository;

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
    private UserRepository userRepository;

    /**
     * 简单dto
     */
    private final Fetcher<User> simpleFetcher = UserFetcher.$.allScalarFields().remove("info");

    /**
     * 原始获取
     *
     * @param id id
     * @return {@link  User}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        Optional<User> byId =
                userRepository.findById(id);
        return ResponseEntity.of(byId);
    }

    /**
     * jimmer 获取
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping("/nullable/{id}")
    public ResponseEntity<User> get2(@PathVariable("id") Long id) {
        User user = userRepository.findNullable(id);
        return ResponseEntity.of(Optional.ofNullable(user));
    }

    /**
     * 获取返回dto
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping("/dto/{id}")
    public ResponseEntity<User> get3(@PathVariable("id") Long id) {
        User user = userRepository.findNullable(id, simpleFetcher);
        return ResponseEntity.of(Optional.ofNullable(user));
    }

    /**
     * 分页获取
     *
     * @param pageable 分页信息
     * @return {@link Page}
     */
    @GetMapping("/list")
    public ResponseEntity<Page<User>> list(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable, simpleFetcher);
        return ResponseEntity.ok(page);
    }

}
