package top.fanxfan.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.server.webmvc.GraphiQlHandler;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * 公开graphql的web功能
 *
 * @author fanxfan
 * @date 2024-01-18
 */
@Configuration
public class GraphIqlConfiguration {

    @Bean
    @Order(0)
    public RouterFunction<ServerResponse> graphiQlRouterFunction() {
        RouterFunctions.Builder builder = RouterFunctions.route();
        ClassPathResource graphIqlPage = new ClassPathResource("graphiql/index.html");
        GraphiQlHandler graphIqlHandler = new GraphiQlHandler("/graphql", "", graphIqlPage);
        builder = builder.GET("/graphiql", graphIqlHandler::handleRequest);
        return builder.build();
    }
}