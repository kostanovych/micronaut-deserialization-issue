plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

val micronautVersion = "4.1.12"
val micronautTestVersion = "4.1.1"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-inject-java:$micronautVersion")

    implementation("org.slf4j:slf4j-simple:2.0.16")
    implementation("io.micronaut:micronaut-runtime:$micronautVersion")
    implementation("io.micronaut:micronaut-http-server-netty:$micronautVersion")
    implementation("io.micronaut:micronaut-jackson-databind:$micronautVersion")

    testAnnotationProcessor("io.micronaut:micronaut-inject-java:$micronautVersion")

    testImplementation("org.slf4j:slf4j-simple:2.0.16")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.micronaut.test:micronaut-test-junit5:$micronautTestVersion")
    testImplementation("io.micronaut:micronaut-runtime:$micronautVersion")
    testImplementation("io.micronaut:micronaut-jackson-databind:$micronautVersion")
    testImplementation("io.micronaut:micronaut-http-client:$micronautVersion")
}

tasks.test {
    useJUnitPlatform()
}
