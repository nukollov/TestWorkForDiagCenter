package com.diagcenter.testwork;

import lombok.*;

import javax.persistence.*;

/**
 * Сущность пациента
 * @author - Nikita Ukolov
 * */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "second_name")
    String secondName;

    @Column(name = "third_name")
    String thirdName;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;
}
