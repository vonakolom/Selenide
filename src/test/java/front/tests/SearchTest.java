package front.tests;

import front.support.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static front.data.ConfigProvider.URL;

@Feature("Поиск информации")
public class SearchTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Поиск сайта погоды")
    public void test() {
        open(URL);
    }

}
