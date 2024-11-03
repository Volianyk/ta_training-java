package com.epam.training.student_volodymyr_volianyk.final_task.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SaucedemoLoginPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/";
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputUserPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement buttonLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); //read about the method
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT_DURATION);
        log.info("Create page: {}", PAGE_URL);
    }

    @Override
    public SaucedemoLoginPage openPage() {
        driver.get(PAGE_URL);
        log.info("{} page was opened", PAGE_URL);
        return this;
    }

    public SaucedemoLoginPage enterName(String name) {
        return enterText(inputUserName, name);
    }

    public SaucedemoLoginPage enterPassword(String password) {
        return enterText(inputUserPassword, password);
    }

    private SaucedemoLoginPage enterText(WebElement target, String input) {
        wait.until(ExpectedConditions.visibilityOf(target));
        target.clear();
        target.sendKeys(input);
        log.info("{} was entered", input);
        return this;
    }

    public SaucedemoLoginPage clearName() {
        return clearInput(inputUserName);
    }

    public SaucedemoLoginPage clearPassword() {
        return clearInput(inputUserPassword);
    }

    private SaucedemoLoginPage clearInput(WebElement target) {
        log.info("{} input will be clear", target.getText());
        wait.until(ExpectedConditions.visibilityOf(target));
        target.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        log.info("clear done");
        return this;
    }

    public SaucedemoLoginPage clickLogin() {
        buttonLogin.click();
        return this;
    }

    public String getErrorMessage() {
         wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String error = errorMessage.getText();
        String processedError = error.replace("Epic sadface: ", ""); //todo need to change, looks like hardcode
        log.info("Error message displayed: {}.", processedError);
        return processedError;
    }

}
