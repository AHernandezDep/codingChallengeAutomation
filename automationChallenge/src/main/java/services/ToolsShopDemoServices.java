package services;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ToolsShopDemoPage;
import utils.BaseTest;
import java.util.List;

import static utils.BaseTest.driver;

public class ToolsShopDemoServices {
    private final ToolsShopDemoPage toolsShopDemoPage = new ToolsShopDemoPage();

    /**
     * Initializes the browser and opens the specified URL.
     * @param browser Nombre del navegador (chrome, firefox, edge).
     * @param url URL a abrir.
     */
    public void openBrowser(String browser, String url) {
        BaseTest.initializeDriver(browser);
        WebDriver driver = BaseTest.driver;
        driver.get(url);
    }

    public void scrollToFilterSection() {
        WebElement txtFilterSection = driver.findElement(toolsShopDemoPage.txtFilterSection);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", txtFilterSection);
    }

    public void enterSearchCriteria(String searchCriteria) {
        WebElement fldInputBox = driver.findElement(toolsShopDemoPage.fldInputBox);
        fldInputBox.click();
        fldInputBox.sendKeys(searchCriteria);
    }

    public void hitTheSearchButton() {
        WebElement btnSearch = driver.findElement(toolsShopDemoPage.btnSearch);
        btnSearch.click();
    }


    public int verifyCriteriaOnPage() throws InterruptedException {
        //Each product displayed must contain in its description the word ' Pliers'.
        long timeout = System.currentTimeMillis() + 5000;
        List<WebElement> cardProducts = null;
        List<WebElement> cardProductsDescription = null;
        
        //Smart wait with retry to allow the page to finish rendering.
        while (System.currentTimeMillis() < timeout) {
            cardProducts = driver.findElements(toolsShopDemoPage.cardsProducts);
            cardProductsDescription = driver.findElements(toolsShopDemoPage.cardsProductsDescripction);
            if (cardProducts.size() == cardProductsDescription.size()) {
                break;
            }
            //Reitent is defined in 0.5s
            Thread.sleep(500);
        }
        return cardProducts.size() - cardProductsDescription.size();
    }
}
