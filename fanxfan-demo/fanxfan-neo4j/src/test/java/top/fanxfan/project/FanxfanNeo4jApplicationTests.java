package top.fanxfan.project;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.fanxfan.project.domain.UserEntity;
import top.fanxfan.project.repository.UserRepository;

@SpringBootTest
@Slf4j
class FanxfanNeo4jApplicationTests {
    @Resource
    UserRepository userRepository;

    /**
     * 创建测试
     */
    @Test
    void create() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("fanxfan");
        userEntity.setSex(2);
        userEntity.setMobile("15812312344");
        UserEntity save = userRepository.save(userEntity);
        Assert.notNull(save, "save fail");
        log.error("save {}", save);
    }

    /**
     * 更新测试
     */
    @Test
    void update() {
        UserEntity byId = userRepository.findById(10L).orElseThrow(() -> new RuntimeException("not found"));
        byId.setUserName("fanxfan-update");
        byId.setSex(2);
        byId.setMobile("15811545125");
        UserEntity save = userRepository.save(byId);
        Assert.notNull(save, "save fail");
        log.error("save {}", save);
    }


}
