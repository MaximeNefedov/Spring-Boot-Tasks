package ru.netology.conditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalApplicationTests {
    private static final String HOST = "http://localhost:";
    private static final String ENDPOINT = "/profile";
    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private GenericContainer<?> app1 = new GenericContainer<>("conditionalapp1:1.0")
            .withExposedPorts(8080);

    @Container
    private GenericContainer<?> app2 = new GenericContainer<>("conditionalapp2:1.0")
            .withExposedPorts(8081);

    @Test
    void testingDeveloperProfileContainer() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST + app1.getMappedPort(8080) + ENDPOINT, String.class);
        System.out.println(responseEntity.getBody());
        Assertions.assertEquals("Current profile is dev", responseEntity.getBody());
    }

    @Test
    void testingProductionProfileContainer() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST + app2.getMappedPort(8081) + ENDPOINT, String.class);
        System.out.println(responseEntity.getBody());
        Assertions.assertEquals("Current profile is production", responseEntity.getBody());
    }
}
