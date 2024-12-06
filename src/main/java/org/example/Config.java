package org.example;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("common")
public interface Config {
    List<SupportedVersion> getSupportedVersions();
}
