package com.epam.training.student_volodymyr_volianyk.web_driver.practice1.test;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.PastebinPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    private WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enteredWalueTest() {
        PastebinPage pastebinPage = new PastebinPage(driver);
        pastebinPage.openPage();

        pastebinPage.enterPasteCode("Hello from WebDriver");
        pastebinPage.selectPasteExpiration("10 Minutes");
        pastebinPage.enterPasteName("helloweb");
        pastebinPage.createNewPaste();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> webDriver.getTitle().contains("helloweb"));

        assertTrue(driver.getTitle().contains("helloweb"), "Page title should contain paste name.");
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
