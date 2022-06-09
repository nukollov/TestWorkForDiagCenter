package com.diagcenter.testwork;

import lombok.*;

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
