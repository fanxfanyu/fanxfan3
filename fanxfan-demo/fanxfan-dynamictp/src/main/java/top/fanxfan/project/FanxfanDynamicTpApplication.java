package top.fanxfan.project;

import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 动态线程池demo
 *
 * @author fanxfan
 * @date 2024/1/26 11:20
 */
@SpringBootApplication
@EnableDynamicTp
@EnableScheduling
public class FanxfanDynamicTpApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(FanxfanDynamicTpApplication.class, args);
    }
}
