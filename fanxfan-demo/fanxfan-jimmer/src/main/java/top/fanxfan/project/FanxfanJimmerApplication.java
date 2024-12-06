package top.fanxfan.project;

import org.babyfish.jimmer.spring.repository.EnableJimmerRepositories;
import org.babyfish.jimmer.sql.EnableDtoGeneration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * fanxfan jimmer
 *
 * @author fanxfan
 * @date 2024/2/23 12:18
 */
@EnableDtoGeneration
@EnableJimmerRepositories
@SpringBootApplication
public class FanxfanJimmerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanxfanJimmerApplication.class, args);
    }
}
