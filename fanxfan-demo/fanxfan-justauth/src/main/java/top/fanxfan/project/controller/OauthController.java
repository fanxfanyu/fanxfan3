package top.fanxfan.project.controller;

import com.alibaba.fastjson.JSON;
import com.xkcoding.justauth.AuthRequestFactory;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 第三方登录
 *
 * @author fanxfan
 * @date 2024-01-19
 */
@Slf4j
@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OauthController {

    private final AuthRequestFactory factory;

    /**
     * 获取第三方登录列表
     *
     * @return 返回
     */
    @GetMapping
    public List<String> list() {
        return factory.oauthList();
    }

    /**
     * 登录跳转到登录页面
     *
     * @param type     第三方登录类型
     * @param response 响应
     */
    @GetMapping("/login/{type}")
    @SneakyThrows
    public void login(@PathVariable String type, HttpServletResponse response) {
        AuthRequest authRequest = factory.get(type);
        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
    }

    /**
     * 登录成功后的回调
     *
     * @param type     第三方登录类型
     * @param callback 回调
     * @return 返回
     */
    @RequestMapping("/{type}/callback")
    public AuthResponse<?> login(@PathVariable String type, AuthCallback callback) {
        AuthRequest authRequest = factory.get(type);
        AuthResponse<?> response = authRequest.login(callback);
        log.info("【response】= {}", JSON.toJSONString(response));
        return response;
    }

}