package pages;

import org.openqa.selenium.By;
import utils.BaseTest;

public class ToolsShopDemoPage extends BaseTest {

    public By txtFilterSection = By.xpath("//h4[contains(@class, 'grid-title') and contains(text(), 'Filters')]");
    public By btnSearch = By.xpath("//button[@data-test='search-submit' and contains(text(), 'Search')]");
    public By fldInputBox = By.xpath("//input[@data-test='search-query']");
    public By cardsProducts = By.xpath("//a[contains(@class, 'card') and contains(@data-test, 'product-')]");
    public By cardsProductsDescripction = By.xpath("//a[contains(@class, 'card') and contains(@data-test, 'product-')]//h5[contains(text(), 'Pliers')]");
}