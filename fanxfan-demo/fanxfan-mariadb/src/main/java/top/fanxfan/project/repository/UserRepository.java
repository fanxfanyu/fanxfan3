package top.fanxfan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fanxfan.project.domain.User;

import java.util.List;

/**
 * @author fanxfan
 * @date 2024/1/10 13:57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    List<User> findUserByUserName(String userName);
}
