package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс представляет собой объект-сущность для базы данных.
 * Он соответствует таблице базы данных с именем tasks.
 */
@Entity
@Table(name = "tasks")
@Data
public class Task {

    /**
     * Поле id является идентификатором (порядковым номером) записи в таблице tasks
     * и генерируется базой данных автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Описание задачи. Не может быть null.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Статус задачи. Может быть равен одному из 3 статусов enum TaskStatus. Не может быть null.
     */
    @Column(nullable = false)
    private TaskStatus status;

    /**
     * Дата и время создания задачи. С помощью статического метода now() класса LocalDateTime
     * дата будет присваиваться полю dateTime для каждой записи автоматически.
     * Установлен формат вывода даты и времени в виде yyyy-MM-dd HH:mm:ss.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

}
