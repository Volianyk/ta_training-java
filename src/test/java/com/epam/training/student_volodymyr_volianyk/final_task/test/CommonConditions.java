package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.util.TestListener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TestListener.class)
public class CommonConditions {
    protected static String browser;

    @BeforeAll
    public static void browserSetup() {
        browser = System.getProperty("browser", "edge");
    }

}
