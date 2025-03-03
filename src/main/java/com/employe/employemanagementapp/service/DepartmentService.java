package com.employe.employemanagementapp.service;

import com.employe.employemanagementapp.model.Department;
import com.employe.employemanagementapp.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    // Внедрение репозитория через конструктор
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Добавить отдел
    @Transactional
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    // Удалить отдел по айди
    @Transactional
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    // Получить список всех отделов
    @Transactional
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }



}
