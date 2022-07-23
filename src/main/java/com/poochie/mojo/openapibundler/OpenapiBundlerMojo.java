package com.poochie.mojo.openapibundler;

import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "bundle", defaultPhase = LifecyclePhase.COMPILE)
public class OpenapiBundlerMojo extends AbstractMojo {

    @Parameter(property = "api")
    private File api;

    @Parameter(property = "output")
    private File output;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info(String.format("bundling api at [%s]", api));
        Bundler bundler = new Bundler();
        try {
            bundler.bundle(api, output);
        } catch (BundlerException e) {
            getLog().error(e.getMessage());
            throw new MojoExecutionException(e);
        }
        getLog().info(String.format("writing bundled api to [%s]", output));
    }
}
