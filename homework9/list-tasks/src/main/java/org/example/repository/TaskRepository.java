package org.example.repository;

import org.example.model.Task;
import org.example.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Интерфейс для соединения и работы с базой данных. Является репозиторием. Использует Spring Data и его интерфейс JpaRepository
 * для поиска, удаления, изменения данных в БД.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Метод для поиска задач по статусу. Не входит в список базовых, но засчет корректного наименования задачи
     * Spring Data понимает, что нужно искать при вызове данного метода.
     * @param status Принимает статус из адресной строки запроса.
     * @return Возвращает список задач с указанным статусом.
     */
    List<Task> findByStatus(TaskStatus status);

    @Modifying
    @Query("UPDATE tasks SET status = :status WHERE id = :id")
    void changeStatus(Long id, TaskStatus status);
}
