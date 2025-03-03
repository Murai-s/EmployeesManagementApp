package com.employe.employemanagementapp.controller;

import com.employe.employemanagementapp.model.Employer;
import com.employe.employemanagementapp.service.EmployerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployerController {

    private final EmployerService employerService;

    // Внедрения сервиса через конструктор
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    // Обработка POST запроса на добавление сотрудника
    @PostMapping
    public ResponseEntity<String> addEmployer(@Valid @RequestBody Employer employer) {
        employerService.addEmployer(employer);
        return ResponseEntity.ok(employer.toString() + " successfully added");
    }

    // Обработка DELETE запроса на удаление сотрудника по айди
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployerById(@PathVariable Long id) {
        employerService.deleteEmployerById(id);
        return ResponseEntity.ok("Employee with ID " + id + " successfully deleted");
    }

    // Обработка GET запроса на получение списка всех сотрудников
    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employersList = employerService.getAllEmployers();
        return ResponseEntity.ok(employersList);
    }

    // Обработка PUT запроса на обновление или добавление сотрудника
    @PutMapping("/{id}")
    public ResponseEntity<String> saveOrUpdateEmployer(@PathVariable Long id, @Valid @RequestBody Employer employer) {
        employer.setId(id); // Устанавливаем ID из пути
        String result = employerService.saveOrUpdateEmployer(employer);
        if (result.contains("created")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED); // 201 для создания
        }
        return ResponseEntity.ok(result); // 200 для обновления
    }

    // Обработка PUT запроа на добавление существующего сотрудника в отдел
    @PutMapping("/{employerId}/department/{departmentId}")
    public ResponseEntity<String> addEmployerToDepartment(@PathVariable Long employerId, @PathVariable Long departmentId) {
        String result = employerService.addEmployerToDepartment(employerId, departmentId);
        return ResponseEntity.ok(result);
    }


}
