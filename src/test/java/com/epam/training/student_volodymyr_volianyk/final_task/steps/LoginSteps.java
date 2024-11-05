package com.epam.training.student_volodymyr_volianyk.final_task.steps;

import com.epam.training.student_volodymyr_volianyk.final_task.driver.DriverFactory;
import com.epam.training.student_volodymyr_volianyk.final_task.model.TestCaseData;
import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoLoginPage;
import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoMainPage;
import com.epam.training.student_volodymyr_volianyk.final_task.service.TestCaseDataCreator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps {

    private WebDriver driver;
    private SaucedemoLoginPage loginPage;
    private SaucedemoMainPage mainPage;
    private TestCaseData testCaseData = TestCaseDataCreator.withCredentialsFromProperty();

    @Before
    public void setDriver() {
        driver = DriverFactory.createDriver(System.getProperty("browser", "edge"));
    }

    @Given("the user is on the login page {string}")
    public void theUserIsOnTheLoginPage(String arg0) {
        loginPage = new SaucedemoLoginPage(driver);
        loginPage.openPage();
    }

    @When("the user enters a username and password")
    public void theUserEntersAUsernameAndPassword() {
        loginPage.enterName(testCaseData.getUsername());
        loginPage.enterPassword(testCaseData.getPassword());
    }

    @And("clears both the username and password fields, then clicks login")
    public void clearsBothTheUsernameAndPasswordFieldsThenClicksLogin() {
        loginPage.clearName();
        loginPage.clearPassword();
        loginPage.clickLogin();
    }

    @Then("the error message should be {string}")
    public void theErrorMessageShouldBe(String arg0) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo("Username is required");
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
