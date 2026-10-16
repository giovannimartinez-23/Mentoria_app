package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/"), handler::listenGETData)
                .and(route(GET("/1"), handler::listenGETDataWrong))
                .and(route(GET("/2"), handler::listenGETDataCorrect))
                .and(route(GET("/test"), handler::listenTestError));
    }
}
