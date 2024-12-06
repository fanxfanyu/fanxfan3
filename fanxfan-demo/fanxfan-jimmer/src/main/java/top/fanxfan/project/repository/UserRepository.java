package top.fanxfan.project.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import top.fanxfan.project.domain.User;

/**
 * @author fanxfan
 * @date 2024/2/23 12:57
 */
public interface UserRepository extends JRepository<User, Long> {

}
