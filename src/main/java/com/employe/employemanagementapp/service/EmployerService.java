package com.employe.employemanagementapp.service;

import com.employe.employemanagementapp.model.Department;
import com.employe.employemanagementapp.model.Employer;
import com.employe.employemanagementapp.repository.DepartmentRepository;
import com.employe.employemanagementapp.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final DepartmentRepository departmentRepository;

    // Внедрение репозитория через конструктор
    public EmployerService(EmployerRepository employerRepository, DepartmentRepository departmentRepository) {
        this.employerRepository = employerRepository;
        this.departmentRepository = departmentRepository;
    }

    // Добавить сотрудника
    @Transactional
    public Employer addEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    // Удалить сотрудника по айди
    @Transactional
    public void deleteEmployerById(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employer with ID " + id + " not found"));
        employer.setDeleted(true);
        employerRepository.save(employer);
    }

    // Получить список всех сотрудников
    @Transactional
    public List<Employer> getAllEmployers() {
        return employerRepository.findByIsDeletedFalse();
    }

    // Обновить сотрудника если есть, создать если нету
    @Transactional
    public String saveOrUpdateEmployer(Employer employer) {
        Long id = employer.getId();
        if (id != null && employerRepository.existsById(id)) {
            employerRepository.save(employer);
            return "Employer successfully updated";
        } else {
            employer.setId(null); // Сбрасываем ID для создания новой записи
            Employer savedEmployer = employerRepository.save(employer);
            return "Employer successfully created with ID: " + savedEmployer.getId();
        }
    }

    @Transactional
    public String addEmployerToDepartment(Long employerId, Long departmentId) {
        // Проверка на существование сотрудника
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new IllegalArgumentException("Employer with ID " + employerId + " not found"));

        // Проверка на существование отдела
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department with ID " + departmentId + " not found"));

        // Привязка сотрудника к отделу
        employer.setDepartment(department);

        // Обновление сотрудника в БД
        employerRepository.save(employer);

        return "Employer with ID " + employerId + " successfully added to department with ID " + departmentId;
    }


}
