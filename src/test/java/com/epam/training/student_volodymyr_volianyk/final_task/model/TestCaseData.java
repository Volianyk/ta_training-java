package com.epam.training.student_volodymyr_volianyk.final_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class TestCaseData {
    private String username;
    private String password;


    @Override
    public String toString() {
        return "TestCaseData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCaseData)) return false;
        TestCaseData testCaseData = (TestCaseData) o;
        return Objects.equals(getUsername(), testCaseData.getUsername()) &&
                Objects.equals(getPassword(), testCaseData.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
