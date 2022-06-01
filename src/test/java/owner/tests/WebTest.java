package owner.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.WebConfig;
import static org.assertj.core.api.Assertions.assertThat;


public class WebTest {
    @Test
    public void testLocal(){
        System.setProperty("host", "local");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.getBrowser()).isEqualTo("CHROME");
        assertThat(config.getVersion()).isEqualTo("100.0");
        assertThat(config.getRemoteUrl())
                .hasProtocol("https")
                .hasHost("localhost")
                .hasPort(4444);

    }
    @Test
    public void testSelenoid(){
        System.setProperty("host", "selenoid");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.getBrowser()).isEqualTo("CHROME");
        assertThat(config.getVersion()).isEqualTo("100.0");
        assertThat(config.getRemoteUrl())
                .hasProtocol("https")
                .hasHost("selenoid.autotests.cloud")
                .hasPath("/wd/hub");
    }
}
