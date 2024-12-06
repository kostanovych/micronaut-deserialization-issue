package org.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(propertySources = "classpath:config.json")
public class MicronautDeserializationTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testVersions() {
        HttpRequest<?> request = HttpRequest.GET("/supported-versions");

        SupportedVersionsResponse response = client.toBlocking().retrieve(request, SupportedVersionsResponse.class);

        assertEquals(
                List.of(new SupportedVersion(0L, OffsetDateTime.of(2024, 12, 1, 0, 0, 0, 0, ZoneOffset.UTC)),
                        new SupportedVersion(1L, OffsetDateTime.of(2024, 12, 2, 0, 0, 0, 0, ZoneOffset.UTC)),
                        new SupportedVersion(2L, null)),
                response.supportedVersions());
    }
}
