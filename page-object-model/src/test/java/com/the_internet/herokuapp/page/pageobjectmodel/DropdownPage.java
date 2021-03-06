package com.the_internet.herokuapp.page.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage extends BasePage {

    private static final By pageTitleLocator = By.tagName("h3");
    private static final By dropdownListLocator = By.id("dropdown");
    private static final By genericDropdownListLocator = By.tagName("select");

    private WebElement getPageTitle() {
        return driver.findElement(pageTitleLocator);
    }

    private Select getDropdownList() {
        return new Select(driver.findElement(dropdownListLocator));
    }

    private List<WebElement> getAllDropdownLists() {
        return driver.findElements(genericDropdownListLocator);
    }

    @Override
    public String getPageTitleText() {
        return getPageTitle().getText();
    }

    public int getNumDropdownLists() {
        return getAllDropdownLists().size();
    }

    public String getCurrentDropdownValue() {
        return getDropdownList().getFirstSelectedOption().getText();
    }

    public List<String> getAllDropdownOptions() {
        List<String> options = new ArrayList<>();
        for (WebElement option : getDropdownList().getOptions()) {
            options.add(option.getText());
        }
        return options;
    }

    public boolean getDropdownMultiSelectionSupported() {
        return getDropdownList().getWrappedElement().getAttribute("multiple") != null;
    }

    public void selectDropdownOption(String option) {
        getDropdownList().selectByVisibleText(option);
    }

    public void selectDropdownOption(int index) {
        getDropdownList().selectByIndex(index);
    }
}