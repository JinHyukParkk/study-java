package org.example.two;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class ContainerTest {

    public static final int PORT = 6379;
    public static final String REDIS_IMAGE_NAME = "redis";
    @Container
    static GenericContainer container = new GenericContainer(REDIS_IMAGE_NAME)
//        .waitingFor(new DockerHealthcheckWaitStrategy())
        .withExposedPorts(PORT)
        .withReuse(true);

    @Test
    void test() {
        System.out.println(container.getMappedPort(PORT));
    }
}
