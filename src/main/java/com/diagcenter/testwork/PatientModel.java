package com.diagcenter.testwork;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PatientModel {
    private String firstName;
    private String secondName;
    private String thirdName;
    private String phone;
    private String address;
}
