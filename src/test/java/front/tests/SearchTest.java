package front.tests;

import front.support.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Feature("Поиск информации")
public class SearchTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Поиск информации о погоде в Перелюбе")
    public void test1() {
        startPage.enterText("Погода в Перелюбе")
                .checkCardWeather("Перелюб, Саратовская область");
    }
}
