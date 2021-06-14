package allurereports;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTestLambda {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void LambdaTest() {
        step("Открыть главную страницу", () -> {
            open(BASE_URL);
        });
        step("Найти репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Перейти в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Открыть вкладку Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверить, что Issue с номером 68 существует", () -> {
            $(withText("#68")).should(Condition.visible);
        });
    }

}
