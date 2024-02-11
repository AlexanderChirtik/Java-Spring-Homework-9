package org.example.repository;

import org.example.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс для соединения и работы с базой данных. Является репозиторием. Использует Spring Data и его интерфейс JpaRepository
 * для поиска, удаления, изменения данных в БД.
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
