package run.ikaros.plugin.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import run.ikaros.server.custom.scheme.CustomSchemeManager;

@Slf4j
@Component
public class CustomSchemeRegister implements InitializingBean {
    private final CustomSchemeManager customSchemeManager;

    public CustomSchemeRegister(CustomSchemeManager customSchemeManager) {
        this.customSchemeManager = customSchemeManager;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        customSchemeManager.register(StarterCustom.class);
    }
}
