package top.fanxfan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fanxfan.project.domain.User;

/**
 * 用户持久层
 *
 * @author fanxfan
 * @date 2024/1/19 13:22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
