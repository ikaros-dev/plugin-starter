package run.ikaros.plugin.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import run.ikaros.api.custom.ReactiveCustomClient;
import run.ikaros.api.exception.NotFoundException;

import java.util.Optional;

@Slf4j
@Component
public class TestComponent implements InitializingBean {
    private final ReactiveCustomClient reactiveCustomClient;
    private StarterCustom starterCustom;

    public TestComponent(ReactiveCustomClient reactiveCustomClient) {
        this.reactiveCustomClient = reactiveCustomClient;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        starterCustom = StarterCustom
                .builder()
                .title("starter")
                .build();
        Optional<StarterCustom> starterCustomOptional = reactiveCustomClient
                .findOne(StarterCustom.class, starterCustom.getTitle())
                .onErrorResume(NotFoundException.class, e -> Mono.empty())
                .blockOptional();
        if(starterCustomOptional.isPresent())  {
            log.info("starter custom exists: {}", starterCustomOptional.get());
        } else {
            reactiveCustomClient.create(starterCustom).block();
            log.info("create starter custom: {}", starterCustom);
        }


    }
}
