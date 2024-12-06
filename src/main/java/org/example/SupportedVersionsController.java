package org.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller
public class SupportedVersionsController {
    @Inject
    private Config config;

    @Get(value = "/supported-versions", produces = MediaType.APPLICATION_JSON)
    public SupportedVersionsResponse getSupportedVersions() {
        return new SupportedVersionsResponse(config.getSupportedVersions());
    }
}
