package com.epam.training.student_volodymyr_volianyk.final_task.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//*[ @class=\"error-message-container error\"]")
    private WebElement errorMessageElement;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); //read about the method
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("Create page: " + PAGE_URL);
    }

    @Override
    public SaucedemoLoginPage openPage() {
        driver.get(PAGE_URL);
        log.info("Login page opened");
        return this;
    }


    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(inputUserName));
        inputUserName.clear();
        inputUserName.sendKeys(username);
        log.info("inside method: enterUsername");
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputUserPassword));
        inputUserPassword.clear();
        inputUserPassword.sendKeys(password);
        log.info("inside method: enterPassword");
    }

    public void clearUsername() {
        inputUserName.clear();
        log.info("inside method: clearUsername");
    }

    public void clearPassword() {
        inputUserPassword.clear();
        log.info("inside method: clearPassword");
    }

    public SaucedemoMainPage clickLoginButton() {
        buttonLogin.click();
        log.info("inside method: clickLoginButton");
        return new SaucedemoMainPage(driver);
    }

    public String getErrorMessage() {
         wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String error = errorMessage.getText();
        log.info("Error message displayed: {}.", error);
        return error;
    }












//    public String getLoggedInUserName()
//    {
//        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
//        return linkLoggedInUser.getAttribute("content");
//    }
//
//    public SaucedemoMainPage login(User user) {
//        inputUserName.sendKeys(user.getUsername());
//        inputUserPassword.sendKeys(user.getPassword());
//        buttonLogin.click();
//        log.info("Login performed");
//        return new SaucedemoMainPage(driver);
//    }
}
