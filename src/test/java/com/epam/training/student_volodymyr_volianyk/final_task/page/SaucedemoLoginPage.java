package com.epam.training.student_volodymyr_volianyk.final_task.page;

import com.epam.training.student_volodymyr_volianyk.final_task.model.User;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class SaucedemoLoginPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement inputUserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputUserPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement buttonLogin;

    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SaucedemoLoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        log.info("Login page opened");
        return this;
    }

    public SaucedemoMainPage login(User user) {
        inputUserName.sendKeys(user.getUsername());
        inputUserPassword.sendKeys(user.getPassword());
        buttonLogin.click();
        log.info("Login performed");
        return new SaucedemoMainPage(driver);
    }
}
