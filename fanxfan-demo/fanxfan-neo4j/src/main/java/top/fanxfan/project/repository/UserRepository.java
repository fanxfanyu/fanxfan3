package top.fanxfan.project.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import top.fanxfan.project.domain.UserEntity;

import java.util.Optional;

/**
 * @author fanxfan
 * @date 2024/1/8 11:39
 */
@Repository
public interface UserRepository extends Neo4jRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String name);

    Optional<UserEntity> findOneByUserName(String name);
}
