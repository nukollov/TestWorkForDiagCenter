package com.diagcenter.testwork;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия с данными таблицы patient
 * @author - Nikita Ukolov
 * */

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{
}
