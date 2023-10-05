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

    /**
     * Coffee Studio's <b>java-springboot-restapi-base-plugin</b> configuration:<br/><br/>
     *
     * That's a simple way to guarantee that essential configuration properties set by this plugin are correctly defined
     * as expected in both {@code application.yaml} and {@code application-test.yaml} files.
     */
    @Test
    @DisplayName("validate 'java-springboot-restapi-base-plugin' configuration properties")
    void validateBasePluginConfig() {
        assertAll("server config",
                () -> _assertPropertyEquals("8080", "server.port"),
                () -> _assertPropertyEquals("/", "server.servlet.context-path"),
                () -> _assertPropertyEquals("always", "server.error.include-message"),
                () -> _assertPropertyEquals("always", "server.error.include-binding-errors"),
                () -> _assertPropertyEquals("on_param", "server.error.include-stacktrace"),
                () -> _assertPropertyEquals("false", "server.error.include-exception")
        );
        assertAll("spring config",
                () -> _assertPropertyEquals("{{project_artifact_id_formatted}}", "spring.application.name"),
                () -> _assertPropertyEquals("ALWAYS", "spring.output.ansi.enabled"),
                () -> _assertPropertyEquals("false", "spring.web.resources.add-mappings"),
                () -> _assertPropertyEquals("true", "spring.mvc.throw-exception-if-no-handler-found")
        );
        assertAll("actuator config",
                () -> _assertPropertyEquals("*", "management.endpoints.jmx.exposure.include"),
                () -> _assertPropertyEquals("health", "management.endpoints.web.exposure.include"),
                () -> _assertPropertyEquals("always", "management.endpoint.health.show-details"),
                () -> _assertPropertyEquals("always", "management.endpoint.health.show-components"),
                () -> _assertPropertyEquals("true", "management.endpoint.health.probes.enabled"),
                () -> _assertPropertyEquals("true", "management.endpoint.health.probes.add-additional-paths")
        );
        assertAll("jackson config",
                () -> _assertPropertyEquals("true", "spring.jackson.serialization.indent_output")
        );
    }

    private void _assertPropertyEquals(Object expected, String propertyName) {
        assertEquals(expected, env.getProperty(propertyName), propertyName);
    }

}