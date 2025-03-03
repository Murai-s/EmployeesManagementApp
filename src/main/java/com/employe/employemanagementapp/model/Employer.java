package com.employe.employemanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Setter // Создает сеттеры для класса
@Getter // Создает геттеры для класса
@NoArgsConstructor // Генерирует конструктор без аргументов
@Entity // Превращает класс в сущность для работы с БД. Поля становятся столбиками в БД.
public class Employer {

    @Id // Первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент
    // ID сотрудника
    private Long id;
    // Имя сотрудника
    private String firstName;
    // Фамилия сотрудника
    private String lastName;
    // Почта сотрудника
    private String email;
    // Должность в компании (директор, обычный работяга и т.д.)
    private String position;

    // Связь многие к одному с отделом. Много сотрудников - один отдел.
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @Override
    public String toString() {
        return "Employer {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }


}
