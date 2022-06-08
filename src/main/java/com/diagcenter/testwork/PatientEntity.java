package com.diagcenter.testwork;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

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
    Long ID;

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
