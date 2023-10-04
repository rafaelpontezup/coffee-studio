package {{project_base_package}};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class {{project_name_capitalized}}ApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    @DisplayName("validate Spring Boot Base plugin configuration properties")
    void validateBasePluginConfig() {
        // server config
        assertEquals("8080", environment.getProperty("server.port"));
        assertEquals("/", environment.getProperty("server.servlet.context-path"));
        assertEquals("always", environment.getProperty("server.error.include-message"));
        assertEquals("always", environment.getProperty("server.error.include-binding-errors"));
        assertEquals("on_param", environment.getProperty("server.error.include-stacktrace"));
        assertEquals("false", environment.getProperty("server.error.include-exception"));
        // spring config
        assertEquals("{{project_artifact_id_formatted}}", environment.getProperty("spring.application.name"));
        assertEquals("ALWAYS", environment.getProperty("spring.output.ansi.enabled"));
        assertEquals("false", environment.getProperty("spring.web.resources.add-mappings"));
        assertEquals("true", environment.getProperty("spring.mvc.throw-exception-if-no-handler-found"));
        // actuator config
        assertEquals("*", environment.getProperty("management.endpoints.jmx.exposure.include"));
        assertEquals("health", environment.getProperty("management.endpoints.web.exposure.include"));
        assertEquals("always", environment.getProperty("management.endpoint.health.show-details"));
        assertEquals("always", environment.getProperty("management.endpoint.health.show-components"));
        assertEquals("true", environment.getProperty("management.endpoint.health.probes.enabled"));
        assertEquals("true", environment.getProperty("management.endpoint.health.probes.add-additional-paths"));
        // jackson config
        assertEquals("true", environment.getProperty("spring.jackson.serialization.indent_output"));
    }

}