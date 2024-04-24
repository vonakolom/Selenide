package front.data;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL_GOOGLE = readConfig().getString("url_google");
    String URL_EDGE = readConfig().getString("url_edge");
}
