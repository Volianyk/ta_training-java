package com.epam.training.student_volodymyr_volianyk.final_task.service;

import com.epam.training.student_volodymyr_volianyk.final_task.model.TestCaseData;

import java.util.stream.Stream;

public class TestCaseDataCreator {
    public static final String TESTDATA_USER_NAME = "testdata.testCaseData.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.testCaseData.password";

    public static TestCaseData withCredentialsFromProperty() {
        return new TestCaseData(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

}
