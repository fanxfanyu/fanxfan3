package top.fanxfan.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanxfan.project.domain.User;
import top.fanxfan.project.repository.UserRepository;

import java.util.List;

/**
 * @author fanxfan
 * @date 2024/1/18 16:23
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @QueryMapping
    public User getUser(@Argument Long id) {
        return userRepository.getReferenceById(id);
    }

    @QueryMapping
    public List<User> users(@Argument String userName){
        return userRepository.findUserByUserName(userName);
    }

}
