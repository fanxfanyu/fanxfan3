package top.fanxfan.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 * @author fanxfan
 * @date 2024/1/19 10:55
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.xkcoding.justauth","top.fanxfan.project"})
public class FanxfanJustAuthApplication {

    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        log.info("getenv:{}", getenv);
        SpringApplication.run(FanxfanJustAuthApplication.class, args);
    }
}
