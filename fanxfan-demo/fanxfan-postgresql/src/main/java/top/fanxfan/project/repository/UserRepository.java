package top.fanxfan.project.repository;

import org.springframework.data.domain.Pageable;
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

    List<User> findUserByUserName(String userName);

    List<User> findUserByUserNameStartingWith(String userName, Pageable page);
}
