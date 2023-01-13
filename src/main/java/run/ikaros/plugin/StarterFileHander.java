package run.ikaros.plugin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import run.ikaros.server.core.file.File;
import run.ikaros.server.core.file.FileHandler;

@Slf4j
@Component
public class StarterFileHander implements FileHandler {
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
