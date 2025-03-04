package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import services.ToolsShopDemoServices;

public class ToolsShopDemoSteps {
    private final ToolsShopDemoServices toolsShopDemoServices = new ToolsShopDemoServices();

    @Given("I open the browser on {string}")
    public void openBrowser(String url) {
        toolsShopDemoServices.openBrowser("chrome", url);
    }

    @And("Navigate to the 'Search' input box")
    public void navigateToSearchInputBox() {
        toolsShopDemoServices.scrollToFilterSection();
    }

    @And("In the 'Search' input box type the search criteria {string}")
    public void enterSearchCriteria(String searchCriteria) {
        toolsShopDemoServices.enterSearchCriteria(searchCriteria);
    }

    @When("Hit the search button")
    public void hitTheSearchButton() {
        toolsShopDemoServices.hitTheSearchButton();
    }

    @Then("Verify that only 'Pliers' are present in the page")
    public void verifyCriteriaOnPage() throws InterruptedException {
        int matchingResults = toolsShopDemoServices.verifyCriteriaOnPage();
        Assert.assertEquals("Items that do not match the search criteria are displayed.",
                matchingResults, 0);
    }
}
