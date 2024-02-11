package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Класс представляет собой объект-сущность для базы данных.
 * Он соответствует таблице базы данных с именем workers.
 */
@Entity
@Table(name = "workers")
@Data
public class Worker {

    /**
     * Поле id является идентификатором (порядковым номером) записи в таблице workers
     * и генерируется базой данных автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя работника
     */
    @Column(nullable = false)
    private String name;

    /**
     * Должность работника
     */
    @Column(nullable = false)
    private String post;
}
