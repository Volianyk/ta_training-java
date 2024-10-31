package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.model.User;
import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoLoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaucedemoPageTest extends CommonConditions {
    @Test
    public void emptyInputTest() {
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver);
        User testUser = new User
                ("standard_use", "secret_sauc", "Epic sadface: Username is required");
        loginPage.openPage();
        loginPage.enterCredentials(loginPage.getInputUserName(), testUser.getUsername());
        loginPage.enterCredentials(loginPage.getInputUserPassword(), testUser.getPassword());
        loginPage.clearInputWithAction(loginPage.getInputUserName(), testUser.getUsername());
        loginPage.clearInputWithAction(loginPage.getInputUserPassword(), testUser.getPassword());
        loginPage.clickButton(loginPage.getButtonLogin());

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = testUser.getMessage();

        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @Test
    public void emptyPasswordTest() {
        User testUser = new User("standard_use", "secret_sauc", "Epic sadface: Password is required1");
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver);
        loginPage.openPage();
        loginPage.enterCredentials(loginPage.getInputUserName(), testUser.getUsername());
        loginPage.enterCredentials(loginPage.getInputUserPassword(), testUser.getPassword());
        loginPage.clearInputWithAction(loginPage.getInputUserPassword(), testUser.getPassword());
        loginPage.clickButton(loginPage.getButtonLogin());

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = testUser.getMessage();

        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @Test
    public void correctInputTest() {
        User testUser = new User("standard_user", "secret_sauce", "Swag Labs");
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver);
        loginPage.openPage();
        String actualErrorMessage = loginPage
                .login(testUser)
                .getPageTitle();

        String expectedErrorMessage = testUser.getMessage();

        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

}
