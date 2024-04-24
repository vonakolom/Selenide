package front.support;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import front.tests.page.ResultPage;
import front.tests.page.StartPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicBoolean;
import static front.data.ConfigProvider.URL_EDGE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TextReportExtension.class)
public class BaseTest {

    protected StartPage startPage = new StartPage();
    protected ResultPage resultPage = new ResultPage();

    private static final AtomicBoolean isSetupCompleted = new AtomicBoolean();

    public static void setup() {
        if(!isSetupCompleted.get()) {
            isSetupCompleted.set(true);
            System.setProperty("selenide.browser", "edge");
//            System.setProperty("selenide.browser", "chrome");
//            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_RESOURCES);
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
        Selenide.open(URL_EDGE);
    }

    @BeforeEach
    public void setUp() {
        Selenide.open(URL_EDGE);
    }

    @AfterAll
    public static void initAfter() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
