package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.driver.DriverFactory;
import com.epam.training.student_volodymyr_volianyk.final_task.model.TestCaseData;
import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoLoginPage;
import com.epam.training.student_volodymyr_volianyk.final_task.page.SaucedemoMainPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import static com.epam.training.student_volodymyr_volianyk.final_task.service.TestCaseDataCreator.withCredentialsFromProperty;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public class SaucedemoPageTest extends CommonConditions {

    @ParameterizedTest
    @MethodSource("loginTestData")
    public void loginEmptyFieldTest(TestCaseData testCaseData) {
        WebDriver driver = DriverFactory.createDriver(browser);
        Assertions.assertThat(
                        new SaucedemoLoginPage(driver)
                                .openPage()
                                .enterName(testCaseData.getUsername())
                                .enterPassword(testCaseData.getPassword())
                                .clearName().clearPassword().clickLogin()
                                .getErrorMessage())

                .isEqualTo("Username is required");
        driver.quit();
    }


    @ParameterizedTest
    @MethodSource("loginTestData")
    public void loginEmptyPasswordTest(TestCaseData testCaseData) {
        WebDriver driver = DriverFactory.createDriver(browser);
        Assertions.assertThat(
                        new SaucedemoLoginPage(driver)
                                .openPage()
                                .enterName(testCaseData.getUsername())
                                .enterPassword(testCaseData.getPassword())

                                .clearPassword()
                                .clickLogin()
                                .getErrorMessage())

                .isEqualTo("Password is required");
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("loginTestData")
    public void successfulLoginTest(TestCaseData testCaseData) {
        WebDriver driver = DriverFactory.createDriver(browser);
        String title = null; //todo fix the method
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(driver)
                .openPage()
                .enterName(testCaseData.getUsername())
                .enterPassword(testCaseData.getPassword())
                .clickLogin();

        title = new SaucedemoMainPage(driver).getPageTitle();

        Assertions.assertThat(title).isEqualTo("Swag Labs");
        driver.quit();
    }

    private static TestCaseData[] loginTestData() {
        return new TestCaseData[]{withCredentialsFromProperty()};
    }
}
