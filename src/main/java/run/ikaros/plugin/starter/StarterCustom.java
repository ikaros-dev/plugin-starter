package run.ikaros.plugin.starter;

import lombok.Builder;
import lombok.Data;
import run.ikaros.server.custom.Custom;
import run.ikaros.server.custom.Name;

@Data
@Builder
@Custom(group = "plugin.ikaros.run", version = "v1alpha1", kind = "StarterCustom")
public class StarterCustom {
    @Name
    private String title;

    private Integer number;
}
