package com.employe.employemanagementapp.controller;

import com.employe.employemanagementapp.model.Department;
import com.employe.employemanagementapp.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    // Внедрение сервиса через конструктор
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Обработка POST запроса на добавление отдела
    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return ResponseEntity.ok("Department successfully created");
    }

    // Обработка DELETE запроса на удаление отдела по айди
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok("Department with ID" + id + " successfully deleted");
    }

    // Обработка GET запроса на получение всех отделов
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departmentsList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentsList);
    }




}
