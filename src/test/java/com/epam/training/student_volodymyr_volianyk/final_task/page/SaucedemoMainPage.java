package com.epam.training.student_volodymyr_volianyk.final_task.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SaucedemoMainPage extends AbstractPage {
    private final Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//div[contains(text(),'Swag Labs') and @class='app_logo']")
    private WebElement pageTitle;

    public SaucedemoMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage openPage() {
        return new SaucedemoMainPage(driver);
    }

    public String getPageTitle() {
        String title = pageTitle.getText();
        log.info("Page title: {}", title);
        return title;
    }
}
