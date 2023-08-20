package com.poochie.mojo.openapibundler;

import io.swagger.v3.core.util.Json;

import java.io.File;
import java.io.IOException;

public class JsonIo implements Io {
    @Override
    public <T> T read(File file, Class<T> type) throws IOException {
        return Json.mapper().readValue(file, type);
    }

    @Override
    public void write(File file, Object data) throws IOException {
        Json.mapper().writeValue(file, data);
    }
}
