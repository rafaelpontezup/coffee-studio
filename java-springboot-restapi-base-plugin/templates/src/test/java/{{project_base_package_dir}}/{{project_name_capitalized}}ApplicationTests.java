package {{project_base_package}};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class {{project_name_capitalized}}ApplicationTests {

    @Autowired
    private Environment env;

    @Test
    @DisplayName("validate Spring Boot Base plugin configuration properties")
    void validateBasePluginConfig() {
        assertAll("server config",
                () -> assertEquals("8080", env.getProperty("server.port"), "server.port"),
                () -> assertEquals("/", env.getProperty("server.servlet.context-path"), "server.servlet.context-path"),
                () -> assertEquals("always", env.getProperty("server.error.include-message"), "server.error.include-message"),
                () -> assertEquals("always", env.getProperty("server.error.include-binding-errors"), "server.error.include-binding-errors"),
                () -> assertEquals("on_param", env.getProperty("server.error.include-stacktrace"), "server.error.include-stacktrace"),
                () -> assertEquals("false", env.getProperty("server.error.include-exception"), "server.error.include-exception")
        );
        assertAll("spring config",
                () -> assertEquals("{{project_artifact_id_formatted}}", env.getProperty("spring.application.name"), "spring.application.name"),
                () -> assertEquals("ALWAYS", env.getProperty("spring.output.ansi.enabled"), "spring.output.ansi.enabled"),
                () -> assertEquals("false", env.getProperty("spring.web.resources.add-mappings"), "spring.web.resources.add-mappings"),
                () -> assertEquals("true", env.getProperty("spring.mvc.throw-exception-if-no-handler-found"), "spring.mvc.throw-exception-if-no-handler-found")
        );
        assertAll("actuator config",
                () -> assertEquals("*", env.getProperty("management.endpoints.jmx.exposure.include"), "management.endpoints.jmx.exposure.include"),
                () -> assertEquals("health", env.getProperty("management.endpoints.web.exposure.include"), "management.endpoints.web.exposure.include"),
                () -> assertEquals("always", env.getProperty("management.endpoint.health.show-details"), "management.endpoint.health.show-details"),
                () -> assertEquals("always", env.getProperty("management.endpoint.health.show-components"), "magement.endpoint.health.show-components"),
                () -> assertEquals("true", env.getProperty("management.endpoint.health.probes.enabled"), "management.endpoint.health.probes.enabled"),
                () -> assertEquals("true", env.getProperty("management.endpoint.health.probes.add-additional-paths"), "management.endpoint.health.probes.add-additional-paths")
        );
        assertAll("actuator config",
                () -> assertEquals("true", env.getProperty("spring.jackson.serialization.indent_output"), "spring.jackson.serialization.indent_output")
        );
    }
}