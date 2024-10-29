package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoLoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaucedemoUCOneTest extends CommonConditions {
    @Test
    public void saucedemoUCOneTest() throws InterruptedException {
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver);
        loginPage.openPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(3000);

        loginPage.clearUsername();
        loginPage.clearPassword();
        Thread.sleep(3000);

        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Username is required";


        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

}
