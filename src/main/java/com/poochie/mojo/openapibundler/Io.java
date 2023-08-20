package com.poochie.mojo.openapibundler;

import java.io.File;
import java.io.IOException;

public interface Io {

    <T> T read(File file, Class<T> type) throws IOException;
    void write(File file, Object data) throws IOException;
}
