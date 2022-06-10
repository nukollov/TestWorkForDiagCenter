package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<PatientEntity> findAllPatients(){return repository.findAll();}

    public void save(PatientEntity patient){repository.save(patient);}

    public void deleteById(Long id){repository.deleteById(id);}

    public PatientEntity findById(Long id){return repository.findById(id).orElseThrow();}
}
