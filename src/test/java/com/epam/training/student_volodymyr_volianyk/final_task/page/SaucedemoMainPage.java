package com.epam.training.student_volodymyr_volianyk.final_task.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class SaucedemoMainPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
    private WebElement pageTitle;

    protected SaucedemoMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Override
    protected AbstractPage openPage() {
        return null;
    }


    public String getPageTitle() {
        String title = pageTitle.getText();
        log.info("Page title obtained: {}", title);
        return title;
    }
}
