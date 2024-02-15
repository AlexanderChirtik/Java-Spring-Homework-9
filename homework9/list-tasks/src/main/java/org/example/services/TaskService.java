package org.example.services;

import lombok.AllArgsConstructor;
import org.example.model.Task;
import org.example.model.TaskStatus;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для взаимодействия с базой данных и использования её методов.
 */
@Service
@AllArgsConstructor
public class TaskService {

    /**
     * Объект интерфейса TaskRepository, с помощью которого будут вызываться методы для работы с БД.
     */
    private final TaskRepository repository;

    /**
     * Получение всех находящихся в БД задач.
     * @return Возвращает список всех задач благодаря методу findAll() интерфейса TaskRepository.
     * Метод создан Spring Data JPA.
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Добавление задачи в список.
     * @param task Принимает новую задачу.
     */
    public void addTask(Task task) {
        repository.save(task);
    }

    /**
     * Поиск задач по определенному статусу.
     * @param status Принимает статус, который есть у нескольких задач.
     * @return Возвращает список задач с указанным статусом.
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Изменение статуса задачи.
     * @param id Принимает порядкой номер задачи.
     * @param task Принимает новую задачу, из которой будет выбран только новый статус.
     * @return Возвращает задачу с указанным номер, но обновленным статусом.
     */
    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task taskForUpdate = optionalTask.get();
            repository.changeStatus(id, task.getStatus());
            return taskForUpdate;
        } else {
            throw new IllegalArgumentException("Task not found by number: " + id);
        }
    }

    /**
     * Удаление задачи по порядковому номеру.
     * @param id Принимает номер задачи, которую нужно удалить.
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    /**
     * Поиск задачи по указанному id.
     * @param id Принимает порядковый номер задачи.
     * @return Для обработки возможного null возвращает класс Optional с вложенной в него задачей.
     */
    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }
}
