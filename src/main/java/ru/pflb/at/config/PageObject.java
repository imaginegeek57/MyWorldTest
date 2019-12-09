package ru.pflb.at.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObject {


    @FindBy(id = "text")
    private WebElement element;

    public void setSearchText(String searchText) {
        element.sendKeys(searchText);
    }

    @FindBy(css = ".home-arrow__search button")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }

    public void search(String searchText) {
        setSearchText(searchText);
        clickSearchButton();
    }

    @FindBy(xpath = "path")
    private WebElement searchXpath;

    public void xPath(String path) {
        searchXpath.findElements(By.xpath(path));
        searchXpath.click();
    }


}
