package top.fanxfan.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author fanxfan
 * @date 2024/2/18 15:38
 */
@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {
    private final StringRedisTemplate stringRedisTemplate;


    /**
     * 设置key-value
     *
     * @param key   key键
     * @param value value值
     * @return 是否成功
     */
    @PostMapping("/{key}/{value}")
    public ResponseEntity<Integer> set(@PathVariable(value = "key") String key, @PathVariable(value = "value") String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return ResponseEntity.ok(200);
    }

    /**
     * 获取key对应的value
     *
     * @param key key键
     * @return value值
     */
    @GetMapping("/{key}")
    public ResponseEntity<Object> get(@PathVariable(value = "key") String key) {
        return ResponseEntity.ok(stringRedisTemplate.opsForValue().get(key));
    }

}
