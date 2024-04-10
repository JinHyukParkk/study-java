package org.example.two;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class ContainerTest {

    @Container
    static GenericContainer container = new GenericContainer("redis")
//        .waitingFor(new DockerHealthcheckWaitStrategy())
        .withExposedPorts(6379);

    @Test
    void test() {
        System.out.println(container.getMappedPort(6379));
    }
}
