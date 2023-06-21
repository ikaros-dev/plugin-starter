package run.ikaros.plugin.starter;

import run.ikaros.api.custom.Custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Custom(group = "starter.ikaros.run", version = "v1alpha1",
    kind = "Config", singular = "config", plural = "configs")
public class ConfigCustom {
    private String field1;
    private String field12;
}
