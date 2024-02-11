package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Worker;
import org.example.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для взаимодействия с базой данных и использования её методов.
 */
@Service
@AllArgsConstructor
public class WorkerService {

    /**
     * Объект интерфейса WorkerRepository, с помощью которого будут вызываться методы для работы с БД.
     */
    private final WorkerRepository repository;

    /**
     * Получение всех находящихся в БД работников.
     * @return Возвращает список всех работников благодаря методу findAll() интерфейса TaskRepository.
     */
    public List<Worker> getAllWorkers() {
        return repository.findAll();
    }

    /**
     * Добавление работника в список.
     * @param worker Принимает нового работника.
     */
    public void addWorker(Worker worker) {
        repository.save(worker);
    }

    /**
     * Поиск работника по указанному id.
     * @param id Принимает порядковый номер работника.
     * @return Для обработки возможного null возвращает класс Optional с вложенной в него задачей.
     */
    public Optional<Worker> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Удаление работника из списка по порядковому номеру.
     * @param id Принимает номер работника.
     */
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }


}
