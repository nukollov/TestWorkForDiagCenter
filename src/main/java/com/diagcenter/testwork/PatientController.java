package com.diagcenter.testwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер, отлавливающий все url-адреса
 * @author - Nikita Ukolov
 * */
@Controller
public class PatientController {

    /**
     * Сервис для работы с пациентами
     * */
    @Autowired
    PatientService patientService;

    /**
     * Метод отображения главной страницы - списка всех пациентов
     * @author - Nikita Ukolov
     * @return - возвращает страницу со всеми пациентами
     * */
    @GetMapping("/")
    public ModelAndView showClientList() {
        ModelAndView mv = new ModelAndView("/allPatients");
        mv.addObject("patients", patientService.findAllPatients());
        return mv;
    }

    /**
     * Метод отображения страницы добавления нового пациента
     * @author - Nikita Ukolov
     * @return - возвращает страницу пустой моделью для заполнения данных о новом пациенте
     * */
    @GetMapping("/addPatient")
    public String showAddPage(Model model) {
        model.addAttribute("patient", new PatientModel());
        return "addPatient";
    }

    /**
     * Метод сохранения нового пациента
     * @author - Nikita Ukolov
     * @param newPatient - модель с заполненными данными о новом пациенте
     * @return - редирект на метод showClientList()
     * */
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

    /**
     * Метод удаления выбранного пациента
     * @author - Nikita Ukolov
     * @param id - id удаляемого пациента
     * @return - редирект на метод showClientList()
     * */
    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
        return "redirect:/";
    }

    /**
     * Метод отображения страницы для редактирования пациента
     * @author - Nikita Ukolov
     * @param id - id редактируемого пациента
     * @return - отображение страницы для изменения пациента
     * */
    @GetMapping("/editPatient/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        model.addAttribute("patient", patientService.findById(id));
        return "editPatient";
    }

    /**
     * Метод редактирования выбранного пациента
     * @author - Nikita Ukolov
     * @param patient - новая информация о пациенте
     * @return - редирект на метод showClientList()
     * */
    @PostMapping("/editChoosePatient/{id}")
    public String editPatient(@ModelAttribute PatientEntity patient){
        System.out.println();
        patientService.save(patient);
        return "redirect:/";
    }
}
