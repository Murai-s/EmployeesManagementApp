package com.employe.employemanagementapp.controller;

import com.employe.employemanagementapp.model.Employer;
import com.employe.employemanagementapp.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployerController {
    private final Logger logger = LoggerFactory.getLogger(EmployerController.class);

    private final EmployerService employerService;

    // Внедрения сервиса через конструктор
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    // Обработка POST запроса на добавление
    @PostMapping
    public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
        logger.warn("employer : {}", employer.getFirstName());
        Employer savedEmployer = employerService.addEmployer(employer);
        return ResponseEntity.ok(savedEmployer);
    }
}
