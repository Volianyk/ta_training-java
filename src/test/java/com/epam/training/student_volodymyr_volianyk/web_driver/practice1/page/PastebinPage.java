package com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PastebinPage extends AbstractPage {
    private static Logger log = LoggerFactory.getLogger(PastebinPage.class);
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement newPasteTextArea;

    @FindBy(xpath = "//*[ @type=\"submit\" and text()= 'Create New Paste']")
    private WebElement createPasteButton;

    @FindBy(xpath = "//*[@id=\"postform-expiration\"]")
    private WebElement expirationDropdown;

    @FindBy(xpath = "//*[@id=\"postform-name\"]")
    WebElement pasteNameField;

    public PastebinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[ @type=\"submit\" and text()= 'Create New Paste']")));
        log.info("Open page: " + HOMEPAGE_URL);
        return this;
    }

    public void enterPasteCode(String code) {
        newPasteTextArea.sendKeys(code);
        log.info("Send value: " + code);
    }

    public void selectPasteExpiration(String expiration) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];", expirationDropdown, expiration);
        log.info("Set expiration time: " + expiration);
    }

    public void enterPasteName(String name) {
        pasteNameField.sendKeys(name);
        log.info("Send name: " + name);
    }

    public void createNewPaste() {
        createPasteButton.click();
        log.info("Click paste button");
    }

}
