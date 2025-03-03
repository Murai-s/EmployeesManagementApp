package com.employe.employemanagementapp.service;

import com.employe.employemanagementapp.model.Employer;
import com.employe.employemanagementapp.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    // Внедрение репозитория через конструктор
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    // Добавить сотрудника
    @Transactional
    public Employer addEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    // Удалить сотрудника по айди
    @Transactional
    public void deleteEmployerById(Long id) {
        employerRepository.deleteById(id);
    }

    // Получить список всех сотрудников
    @Transactional
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
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


}
