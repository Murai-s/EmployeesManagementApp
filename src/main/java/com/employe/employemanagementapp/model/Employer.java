package com.employe.employemanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//@Data // Содержит в себе @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@Setter
@Getter
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями класса
@Builder // Более удобное создание объектов класса
@Entity // Превращает класс в сущность для работы с БД. Поля становятся столбиками в БД.
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
