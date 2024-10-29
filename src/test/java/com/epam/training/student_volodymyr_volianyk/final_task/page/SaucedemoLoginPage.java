package com.epam.training.student_volodymyr_volianyk.final_task.page;

import com.epam.training.student_volodymyr_volianyk.final_task.model.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SaucedemoLoginPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement inputUserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputUserPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[ @class=\"error-message-container error\"]")
    private WebElement errorMessageElement;

    private String errorMessage;

    //private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']");

    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        log.info("Open page: "+PAGE_URL);
    }

    @Override
    public SaucedemoLoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        log.info("Login page opened");
        return this;
    }


    public void enterUsername(String username) {
        inputUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputUserPassword.sendKeys(password);
    }

    public void clearUsername() {
        inputUserName.clear();
    }

    public void clearPassword() {
        inputUserPassword.clear();
    }

    public void clickLoginButton() {
        buttonLogin.click();
        errorMessage = errorMessageElement.getText();
    }

    public String getErrorMessage() {
        return errorMessage;
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
