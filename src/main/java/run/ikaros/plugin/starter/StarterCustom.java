package run.ikaros.plugin.starter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.ikaros.server.custom.Custom;
import run.ikaros.server.custom.Name;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Custom(group = "plugin.ikaros.run", version = "v1alpha1",
        kind = "StarterCustom", singular = "starter", plural = "starters")
public class StarterCustom {
    @Name
    private String title;

    private Integer number;
}
