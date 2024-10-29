package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoLoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaucedemoUCOneTest extends CommonConditions {
    @Test
    public void saucedemoUCOneTest() {
        // Enter any dummy credentials
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver);
        loginPage.enterUsername("dummyUser");
        loginPage.enterPassword("dummyPassword");

        // Clear the credentials
        loginPage.clearUsername();
        loginPage.clearPassword();

        // Click the Login button and store the error message
        loginPage.clickLoginButton();

        // Verify the error message from the field
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Username is required";

        // Assert the error message using AssertJ
        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

}
