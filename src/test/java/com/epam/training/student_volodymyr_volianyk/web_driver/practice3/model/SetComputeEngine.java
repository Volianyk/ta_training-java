package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SetComputeEngine {
    private String numberOfInstances;
    private String operatingSystemOrSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private Boolean select;
    private String gPUType;
    private String numberOfGPUs;
    private String localSSD;
    private String region;
}
