package owner.config;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources({"classpath:config/${host}.properties"})
public interface WebConfig extends Config {

    @Key("browser.version")
    @DefaultValue("100.0")
    String getVersion();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("remoteUrl")
    @DefaultValue("https://localhost:4444/wd/hub/")
    URL getRemoteUrl();
}
