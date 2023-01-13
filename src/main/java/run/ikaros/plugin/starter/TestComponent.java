package run.ikaros.plugin.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import run.ikaros.server.custom.ReactiveCustomClient;

@Slf4j
@Component
public class TestComponent implements InitializingBean {
    private final ReactiveCustomClient reactiveCustomClient;

    public TestComponent(ReactiveCustomClient reactiveCustomClient) {
        this.reactiveCustomClient = reactiveCustomClient;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        reactiveCustomClient.create(StarterCustom
                .builder()
                .title("starter")
                .build()).block();
        log.info("create starter custom");

        StarterCustom starterCustom = reactiveCustomClient.findOne(StarterCustom.class, "starter").block();
        log.info("find starter custom: {}", starterCustom);

    }
}
