package com.poochie.mojo.openapibundler;

import io.swagger.v3.oas.models.OpenAPI;

import java.io.File;
import java.io.IOException;

public class Bundler {
    public void bundle(File api, File output) throws BundlerException {
        try {
            OpenAPI bundled = getIoForFile(api).read(api, OpenAPI.class);
            getIoForFile(output).write(output, bundled);
        } catch (IOException e) {
            throw new BundlerException("failed to bundle: " + e.getMessage(), e);
        }
    }

    private Io getIoForFile(File file) throws BundlerException {
        if (!file.isFile()) {
            throw new BundlerException(String.format("%s must be a file", file));
        }
        if (isYaml(file)) {
            return new YamlIo();
        }
        if (isJson(file)) {
            return new JsonIo();
        }

        throw new BundlerException(String.format("unexpected format for file %s, file must have either .yaml .yml or .json extension", file));
    }

    private boolean isYaml(File file) {
        return (file.getName().endsWith(".yaml") || file.getName().endsWith(".yml"));
    }

    private boolean isJson(File file) {
        return (file.getName().endsWith(".json"));
    }
}
