package com.employe.employemanagementapp.service;

import com.employe.employemanagementapp.model.Employer;
import com.employe.employemanagementapp.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    // Внедрение репозитория через конструктор
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Transactional
    public Employer addEmployer(Employer employer) {
        return employerRepository.save(employer);
    }



}
