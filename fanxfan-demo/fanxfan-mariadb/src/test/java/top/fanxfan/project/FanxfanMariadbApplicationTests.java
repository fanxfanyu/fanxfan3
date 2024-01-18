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
class FanxfanMariadbApplicationTests {
    @Resource
    UserRepository userRepository;

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
