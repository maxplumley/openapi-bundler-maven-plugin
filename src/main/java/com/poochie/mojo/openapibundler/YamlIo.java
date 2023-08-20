package com.poochie.mojo.openapibundler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Yaml;

import java.io.File;
import java.io.IOException;

public class YamlIo implements Io {
    @Override
    public <T> T read(File file, Class<T> type) throws IOException {
        return Yaml.mapper().readValue(file, type);
    }

    @Override
    public void write(File file, Object data) throws IOException {
        Yaml.mapper().writeValue(file, data);
    }
}
