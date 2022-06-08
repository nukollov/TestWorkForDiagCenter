package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MyController {
    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public ModelAndView showClientList() {
        ModelAndView mv = new ModelAndView("/allPatients");
        mv.addObject("patients", patientService.findAllPatients());
        return mv;
        //model.addAttribute("patients", patientService.findAllPatients());
        //return "allPatients";
    }

    @GetMapping("/addPatient")
    public String showAddPage(Model model) {
        model.addAttribute("patient", new PatientModel());
        return "addPatient";
    }

    @PostMapping("/addNewPatient")
    public String saveNewPatient(@ModelAttribute PatientModel newPatient){
        PatientEntity patient = PatientEntity.builder()
                .firstName(newPatient.getFirstName())
                .secondName(newPatient.getSecondName())
                .thirdName(newPatient.getThirdName())
                .phone(newPatient.getPhone())
                .address(newPatient.getAddress())
                .build();
        patientService.save(patient);
        return "redirect:/";
    }
}
