package com.epam.training.student_volodymyr_volianyk.final_task.page;

import com.epam.training.student_volodymyr_volianyk.final_task.model.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class SaucedemoLoginPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/";
    private WebDriverWait wait;

    @Getter
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUserName;

    @Getter
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputUserPassword;
    @Getter
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
        log.info("Create page: {}", PAGE_URL);
    }

    @Override
    public SaucedemoLoginPage openPage() {
        driver.get(PAGE_URL);
        log.info("{} page was opened", PAGE_URL);
        return this;
    }

    public void enterCredentials(WebElement target, String input) {
        wait.until(ExpectedConditions.visibilityOf(target));
        target.clear();
        target.sendKeys(input);
        log.info("{} was entered", input);
    }

    public void clearInputWithAction(WebElement target, String inputName) {
        var actions = new Actions(driver);
        actions.doubleClick(target)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        log.info("{} input was cleared", inputName);
    }


    public void clickButton(WebElement target) {
        target.click();
        log.info("{} was clicked", target);
    }

    public String getErrorMessage() {
         wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String error = errorMessage.getText();
        log.info("Error message displayed: {}.", error);
        return error;
    }

    public SaucedemoMainPage login(User user) {
        inputUserName.sendKeys(user.getUsername());
        inputUserPassword.sendKeys(user.getPassword());
        buttonLogin.click();
        log.info("Login performed");
        return new SaucedemoMainPage(driver);
    }
}
