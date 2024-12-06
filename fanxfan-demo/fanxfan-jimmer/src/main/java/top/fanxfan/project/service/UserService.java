package top.fanxfan.project.service;

import cn.hutool.core.text.CharSequenceUtil;
import jakarta.annotation.Resource;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.springframework.stereotype.Service;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.domain.UserFetcher;
import top.fanxfan.project.domain.UserTable;
import top.fanxfan.project.repository.UserRepository;

/**
 * @author fanxfan
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    // 引入fetcher
    private final Fetcher<User> userFetcher = UserFetcher.$.allScalarFields();

    @Resource
    private JSqlClient sqlClient;

    /**
     * 获取指定id用户
     *
     * @param id 用户id
     * @return 用户
     * @throws RuntimeException 用户不存在
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    /**
     * 保存用户
     *
     * @param user 用户
     * @return true
     */
    public boolean saveUser(User user) {
        userRepository.insert(user);
        return true;
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return true
     */
    public boolean updateUser(User user) {
        userRepository.update(user);
        return true;
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return true
     * throws RuntimeException 用户不存在
     */
    public boolean deleteUser(Long id) {
        User byId = userRepository.findById(id).orElseThrow(() -> new RuntimeException("用户不存在"));
        userRepository.delete(byId);
        return true;
    }

    /**
     * 根据用户名，手机号进行分页查询
     *
     * @param username 用户名
     * @param mobile   手机号
     * @param page     当前页
     * @param size     每页大小
     * @return 用户列表
     */
    public Page<User> getUsers(String username, String mobile, int page, int size) {
        UserTable table = UserTable.$;
        return sqlClient.createQuery(table)
                .whereIf(CharSequenceUtil.isNotBlank(username), table.userName().like(username))
                .whereIf(CharSequenceUtil.isNotBlank(mobile), table.mobile().eq(mobile))
                .select(table)
                .fetchPage(page, size);
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    public User login(String username, String password) {
        UserTable table = UserTable.$;
        User user = sqlClient.
                createQuery(table)
                .where(table.userName().eq(username))
                .select(table)
                .fetchOptional()
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        if (user.password().equals(password)) {
            return user;
        }
        throw new RuntimeException("用户或密码错误");
    }
}
