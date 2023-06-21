package run.ikaros.plugin.starter;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import run.ikaros.api.core.setting.ConfigMap;
import run.ikaros.api.custom.ReactiveCustomClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class ConfigController {
    private final ReactiveCustomClient reactiveCustomClient;
    /**
     * 请与[plugin.yaml]文件中的[name]保持一致.
     */
    private static final String pluginName = "PluginStarter";

    public ConfigController(ReactiveCustomClient reactiveCustomClient) {
        this.reactiveCustomClient = reactiveCustomClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public Mono<Void> initConfigMap() {
        ConfigMap configMap = new ConfigMap();
        configMap.setName(pluginName);
        configMap.putDataItem("username", "test1");
        configMap.putDataItem("password", "test2");
        return reactiveCustomClient.create(configMap).then();
    }
}
