package com.poochie.mojo.openapibundler;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.inject.Inject;
import java.io.File;

@Mojo(name = "bundle", defaultPhase = LifecyclePhase.COMPILE)
public class OpenapiBundlerMojo extends AbstractMojo {

    @Parameter(property = "api")
    private File api;

    @Parameter(property = "output")
    private File output;

    @Inject
    Bundler bundler;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info(String.format("bundling api at [%s]", api));
        try {
            bundler.bundle(api, output);
        } catch (BundlerException e) {
            getLog().error(e.getMessage());
            throw new MojoExecutionException(e);
        }
        getLog().info(String.format("writing bundled api to [%s]", output));
    }
}
