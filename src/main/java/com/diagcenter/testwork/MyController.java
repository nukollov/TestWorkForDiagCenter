package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        //model.addAttribute("patients", patientService.findAllPatients());
        //return "allPatients";
    }
    
}
