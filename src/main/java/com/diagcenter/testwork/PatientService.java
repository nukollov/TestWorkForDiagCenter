package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<PatientEntity> findAllPatients(){return repository.findAll();}
}
