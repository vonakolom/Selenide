package front.tests.page;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница результатов поиска
 */
public class ResultPage {

    public void checkCardWeather(String city) {
        $x("//span[@class='wtr_foreGround']")
                .shouldBe(visible)
                .shouldHave(exactText(city));
    }
}
