package com.poochie.mojo.openapibundler;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import java.io.File;
import java.io.IOException;

public class Bundler {
    public void bundle(File api, File output) throws BundlerException {
        try {
            OpenAPI bundled = Yaml.mapper().readValue(api, OpenAPI.class);
            Yaml.mapper().writeValue(output, bundled);
        } catch (IOException e) {
            throw new BundlerException("failed to bundle: " + e.getMessage(), e);
        }
    }
}
