package top.fanxfan.project.consumer;

import cn.org.wangchangjiu.redis.delay.RedisDelayMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 模拟消费者
 *
 * @author fanxfan
 * @date 2024/2/18 16:59
 */
@Component
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unused")
public class DelayConsumer {

    @RedisDelayMessageListener(topic = "delay")
    public void consumer(Object message) {
        log.error("message {}", message);
    }
}
