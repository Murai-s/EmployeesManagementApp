package com.employe.employemanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter // Создает сеттеры для класса
@Getter // Создает геттеры для класса
@NoArgsConstructor // Генерирует конструктор без аргументов
@Entity // Превращает класс в сущность для работы с БД. Поля становятся столбиками в БД.
public class Employer {

    @Id // Первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент
    private Long id; // ID сотрудника

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName; // Имя сотрудника

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName; // Фамилия сотрудника

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email; // Почта сотрудника

    @NotBlank(message = "Position cannot be empty")
    @Size(min = 2, max = 100, message = "Position must be between 2 and 100 characters")
    private String position; // Должность в компании (директор, обычный работяга и т.д.)

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
