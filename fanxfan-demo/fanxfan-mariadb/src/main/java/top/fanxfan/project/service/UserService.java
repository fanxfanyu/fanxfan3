package top.fanxfan.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.repository.UserRepository;

import java.util.List;

/**
 * 用户服务
 *
 * @author fanxfan
 * @date 2024-01-18
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> users(String userName) {
        if (userName == null) {
            return userRepository.findAll(PageRequest.of(1, 10)).getContent();
        }
        return userRepository.findUserByUserName(userName);
    }
}