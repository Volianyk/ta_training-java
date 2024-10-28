package com.epam.training.student_volodymyr_volianyk.final_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SaucedemoMainPage extends AbstractPage {

    protected SaucedemoMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
