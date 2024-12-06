package org.example;

import java.time.OffsetDateTime;

public record SupportedVersion(Long version, OffsetDateTime expirationDate) {
}
