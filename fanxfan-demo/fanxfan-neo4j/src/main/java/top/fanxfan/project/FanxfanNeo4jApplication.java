package top.fanxfan.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 *
 * @author fanxfan
 * @date 2024/1/8 11:39
 */
@SpringBootApplication
// @EnableReactiveNeo4jRepositories
public class FanxfanNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanxfanNeo4jApplication.class, args);
    }

}
