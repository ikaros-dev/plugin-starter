package run.ikaros.plugin.starter;

import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import run.ikaros.server.core.file.File;
import run.ikaros.server.core.file.FileHandler;
import run.ikaros.server.custom.ReactiveCustomClient;

@Slf4j
@Extension
public class StarterFileHandler implements FileHandler {

    private final ReactiveCustomClient reactiveCustomClient;

    public StarterFileHandler(ReactiveCustomClient reactiveCustomClient) {
        this.reactiveCustomClient = reactiveCustomClient;
    }

    @Override
    public File upload(UploadContext context) {
        log.info("Starter file handler upload");
        return null;
    }

    @Override
    public File delete(File file) {
        log.info("Starter file handler delete");
        return null;
    }
}
