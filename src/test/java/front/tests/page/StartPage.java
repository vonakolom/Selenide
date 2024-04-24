package front.tests.page;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Стартовая страница поиска
 */
public class StartPage {

    public ResultPage enterText(String text) {
        $x("//input[@id='sb_form_q']")
                .setValue(text)
                .pressEnter();
        return page(ResultPage.class);
    }
}
