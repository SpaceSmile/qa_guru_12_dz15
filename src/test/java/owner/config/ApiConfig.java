package owner.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:config/api.properties"
})
public interface ApiConfig extends Config {

        @Key("baseUrl")
        @DefaultValue("https://www.rambler.ru")
        String baseUrl();

        @Key("token")
        @DefaultValue("rambler_token")
        String token();
}
