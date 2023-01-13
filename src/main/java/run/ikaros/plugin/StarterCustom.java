package run.ikaros.plugin;

import lombok.Data;
import run.ikaros.server.custom.Custom;
import run.ikaros.server.custom.Name;

@Data
@Custom(group = "plugin.ikaros.run", version = "v1alpha1", kind = "StarterCustom")
public class StarterCustom {
    @Name
    private String title;

    private Integer number;
}
