package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Task;
import org.example.model.TaskStatus;
import org.example.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Класс для взаимодействия с внешними пользователями.
 */
@RestController
@RequestMapping("/serviceA")
@AllArgsConstructor
public class TaskController {

    /**
     * Экземпляр класса TaskService для использования методов сервиса.
     */
    private final TaskService service;

    /**
     * Обработка отправленной задачи для внесения её в базу данных.
     * @param task Принимает новую задачу в теле запроса. В задаче можно указать только description и status.
     * @return Возвращает список всех задач для наглядной демонстрации, что новая задача была добавлена.
     */
    @PostMapping("/add")
    public List<Task> addTask(@RequestBody Task task) {
        service.addTask(task);
        return service.getAllTasks();
    }

    /**
     * Получение списка всех задач.
     * @return Возвращает список задач.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    /**
     * Возвращение задачи по её идентификационному номеру.
     * @param id Принимает номер задачи из адресной строки запроса.
     * @return Возвращает задачу.
     */
    @GetMapping("/{id}")
    public Optional<Task> findTaskById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Поиск задач по указанному статусу.
     * @param status Принимает статус из адресной строки запроса.
     * @return Возвращает список задач с указанным статусом.
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getTasksByStatus(status);
    }

    /**
     * Изменение статуса задачи по её id.
     * @param id Принимает номер задачи из адресной строки запроса.
     * @param task Принимает новую задачи из тела запроса.
     * @return Возвращает обновленную задачу.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskStatus(id, task);
    }

    /**
     * Удаление задачи по её id.
     * @param id Принимает номер задачи из адресной строки запроса.
     * @return Возвращает информационное сообщение о том, что задача была удалена.
     */
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "Task deleted";
    }
}
