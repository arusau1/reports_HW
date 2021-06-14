package allurereports;

import org.junit.jupiter.api.Test;

public class SelenideTestAnnotated {

    private WebSteps steps = new WebSteps();

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository("eroshenkoam/allure-example");
        steps.goToRepository("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(68);
    }

}
