package com.employe.employemanagementapp.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employer")
public class Employer {

    // Геттеры и сеттеры
    // ID сотрудника
    @Id // Первичный ключ
    // Автоинкремент
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Имя сотрудника
    private String firstName;
    // Фамилия сотрудника
    private String lastName;
    // Почта сотрудника
    private String email;
    // Должность в компании (директор, обычный работяга и т.д.)
    private String position;

}
