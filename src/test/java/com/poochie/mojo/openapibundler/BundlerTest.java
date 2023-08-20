package com.poochie.mojo.openapibundler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class BundlerTest {

    private Bundler bundler;

    @BeforeEach
    void setup() {
        bundler = new Bundler();
    }

    @Test
    @DisplayName("GIVEN valid api file WHEN bundled THEN api bundled to output")
    void testBundle() throws BundlerException, IOException {
        URL resource = this.getClass().getClassLoader().getResource("test/api/openapi.yaml");
        File outFile = new File("./test/output/openapi.yaml");
        outFile.getParentFile().mkdirs();
        bundler.bundle(new File(resource.getPath()), outFile);
    }
}
