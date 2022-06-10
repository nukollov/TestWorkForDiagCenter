package com.diagcenter.testwork;

import lombok.*;

/**
 * Модель для получения с клиента данных о созданном пациенте
 * @author - Nikita Ukolov
 * */

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
