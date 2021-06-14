package allurereports;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
    }

    @Step("Перейти в репозиторий {repository}")
    public void goToRepository(String repository) {

        $(By.linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Открыть вкладку Issues")
    public void openIssueTab() {

        $(withText("Issues")).click();
    }

    @Step("Проверить, что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#68")).should(Condition.visible);
    }

}
