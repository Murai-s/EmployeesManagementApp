package com.employe.employemanagementapp.repository;

import com.employe.employemanagementapp.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Наследуемся от JpaRepository, в нем базовые методы (save, findById, delete и т.д.)
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

}
