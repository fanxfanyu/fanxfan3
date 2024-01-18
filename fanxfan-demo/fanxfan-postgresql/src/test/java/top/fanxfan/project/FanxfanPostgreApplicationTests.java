package top.fanxfan.project;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.repository.UserRepository;

@SpringBootTest
@Slf4j
class FanxfanPostgreApplicationTests {
    @Resource
    UserRepository userRepository;

    /**
     * 测试新增用户
     */
    @Test
    void create() {
        User user = new User();
        user.setUserName("fanxfan");
        user.setSex(0);
        user.setMobile("1580000000");
        user.setInfo("12212");
        User save = userRepository.saveAndFlush(user);
        log.error("user {},save {}", user, save);

    }

    /**
     * 测试分页查询
     */
    @Test
    void query() {
        for (int i = 0; i < 100; i++) {
            int pageNumber = RandomUtil.randomInt(1, 10000);
            log.error("pageNumber:{}", pageNumber);
            Page<User> all = userRepository.findAll(PageRequest.of(pageNumber, 10));
            log.error("pageNumber:{},all {}", pageNumber, all);
        }
    }

}
