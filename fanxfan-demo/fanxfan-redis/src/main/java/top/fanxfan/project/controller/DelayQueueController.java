package top.fanxfan.project.controller;

import cn.hutool.core.util.RandomUtil;
import cn.org.wangchangjiu.redis.delay.DelayQueueMessageProducer;
import cn.org.wangchangjiu.redis.delay.RedissonDelayQueue;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author fanxfan
 * @date 2024/2/18 16:12
 */
@RestController
@RequestMapping("/delay")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DelayQueueController {

    private final RedissonClient redissonClient;

    /**
     * 添加消息
     *
     * @return 是否成功
     */
    @PostMapping("/add")
    public ResponseEntity<Integer> add() {
        RedissonDelayQueue redissonDelayQueue = new RedissonDelayQueue(redissonClient);
        redissonDelayQueue.addDelayQueue(RandomUtil.randomString(10), 10000L, TimeUnit.MILLISECONDS, "delay");
        DelayQueueMessageProducer delayQueueMessageProducer = new DelayQueueMessageProducer(redissonDelayQueue, "delay");
        delayQueueMessageProducer.sendMessage("delay", RandomUtil.randomString(10), 10000L, TimeUnit.MILLISECONDS);
        return ResponseEntity.ok(200);
    }

    /**
     * 获取消息
     *
     * @return 消息
     */
    @GetMapping
    public ResponseEntity<Object> get() {
        RedissonDelayQueue redissonDelayQueue = new RedissonDelayQueue(redissonClient);
        Object value = redissonDelayQueue.getDelayQueue("delay");
        return ResponseEntity.ok(value);
    }

}