package owner.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.ApiConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiTest {
    @Test
    public void testClasspath(){
        ApiConfig config = ConfigFactory
                .create(ApiConfig.class, System.getProperties());
        assertThat(config.baseUrl()).isEqualTo("https://www.rambler.ru");
        assertThat(config.token()).isEqualTo("rambler_token");
    }

    @Test
    public void testLocalFile () throws IOException {
        String content = "baseUrl=https://www.rambler.ru\ntoken=rambler_token";
        Path propsPath = Paths.get("/tmp/secret.properties");
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));
        ApiConfig config = ConfigFactory
                .create(ApiConfig.class, System.getProperties());
        assertThat(config.baseUrl()).isEqualTo("https://www.rambler.ru");
        assertThat(config.token()).isEqualTo("rambler_token");
        Files.delete(propsPath);


    }

}
