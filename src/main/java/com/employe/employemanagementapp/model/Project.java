package com.employe.employemanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data // Содержит в себе @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями класса
@Builder // Более удобное создание объектов класса
@Entity // Превращает класс в сущность для работы с БД. Поля становятся столбиками в БД.
public class Project {

    // ID проекта
    @Id // Первичный ключ, авто инкремент
    private Long id;
    // Имя проекта
    private String name;
    // Описание проекта
    private String description;
    // Дата создания проекта
    private LocalDate createDate;
}
