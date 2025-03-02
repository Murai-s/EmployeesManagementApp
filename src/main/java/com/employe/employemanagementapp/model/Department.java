package com.employe.employemanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Содержит в себе @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями класса
@Builder // Более удобное создание объектов класса
@Entity // Превращает класс в сущность для работы с БД. Поля становятся столбиками в БД.
public class Department {

    // ID отдела
    @Id // Первичный ключ, авто инкремент
    private Long id;
    // Название отдела
    private String name;
    // Местоположение отдела
    private String location;
}
