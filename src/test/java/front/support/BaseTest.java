package front.support;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.atomic.AtomicBoolean;

import static front.data.ConfigProvider.URL;

public class BaseTest {

    private static final AtomicBoolean isSetupCompleted = new AtomicBoolean();

    public static void setup() {
        if(!isSetupCompleted.get()) {
            isSetupCompleted.set(true);
            System.setProperty("selenide.browser", "chrome");
 //           System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_RESOURCES);
            Configuration.browserSize = "1280x860";
            Configuration.timeout = 10000;
            Configuration.pageLoadTimeout = 300000;
            Configuration.headless = false;
            Configuration.proxyEnabled = false;
        }
    }

    @BeforeAll
    public static void setUpAll() {
        BaseTest.setup();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open(URL);
    }

    @BeforeEach
    public void setUp() {
        Selenide.open(URL);
    }

    @AfterAll
    public static void initAfter() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
