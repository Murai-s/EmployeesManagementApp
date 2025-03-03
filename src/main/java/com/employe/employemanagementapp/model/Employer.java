package com.employe.employemanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
