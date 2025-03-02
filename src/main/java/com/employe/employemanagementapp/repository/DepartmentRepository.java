package com.employe.employemanagementapp.repository;

import com.employe.employemanagementapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Наследуемся от JpaRepository, в нем базовые методы (save, findById, delete и т.д.)
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
