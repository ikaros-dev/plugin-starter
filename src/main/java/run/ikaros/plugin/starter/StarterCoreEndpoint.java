package run.ikaros.plugin.starter;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import run.ikaros.api.custom.ReactiveCustomClient;
import run.ikaros.api.endpoint.CoreEndpoint;

import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Slf4j
@Component
public class StarterCoreEndpoint implements CoreEndpoint {

    private final ReactiveCustomClient reactiveCustomClient;

    public StarterCoreEndpoint(ReactiveCustomClient reactiveCustomClient) {
        this.reactiveCustomClient = reactiveCustomClient;
    }

    @Override
    public RouterFunction<ServerResponse> endpoint() {
        return SpringdocRouteBuilder.route()
                .GET("/starter/findAll",contentType(MediaType.APPLICATION_JSON), this::findAll,
                        builder -> builder
                                .operationId("findAll")
                                .tag("testPlugin"))
                .build();
    }

    Mono<ServerResponse> findAll(ServerRequest request) {
        return reactiveCustomClient.findAll(StarterCustom.class, null)
                .collectList()
                .flatMap(custom -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(custom));
    }

}
