package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public ModelAndView showClientList() {
        ModelAndView mv = new ModelAndView("/allPatients");
        mv.addObject("patients", patientService.findAllPatients());
        return mv;
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

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editPatient/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        model.addAttribute("patient", patientService.findById(id));
        return "editPatient";
    }

    @PostMapping("/editChoosePatient/{id}")
    public String editPatient(@ModelAttribute PatientEntity patient){
        System.out.println();
        patientService.save(patient);
        return "redirect:/";
    }
}
