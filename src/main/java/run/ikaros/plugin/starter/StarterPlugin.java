package run.ikaros.plugin.starter;


import lombok.extern.slf4j.Slf4j;
import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Component;
import run.ikaros.server.plugin.BasePlugin;

@Slf4j
@Component
public class StarterPlugin extends BasePlugin {

    public StarterPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        log.info("plugin [plugin-starter] start success");
    }

    @Override
    public void stop() {
        log.info("plugin [plugin-starter] stop success");
    }

    @Override
    public void delete() {
        log.info("plugin [plugin-starter] delete success");
    }
}