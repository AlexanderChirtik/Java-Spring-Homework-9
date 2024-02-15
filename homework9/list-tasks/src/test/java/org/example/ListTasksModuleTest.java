package org.example;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.example.model.TaskStatus.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ListTasksModuleTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void updateTask() {
        //preconditions
        Task task1 = new Task();
        task1.setId(1L);
        task1.setDescription("Task 1 for test");
        task1.setStatus(NOT_STARTED);

        Task task2 = new Task();
        task2.setDescription("Task 2 for test");
        task2.setStatus(IN_PROGRESS);

        given(taskRepository.findById(1L)).willReturn(Optional.of(task1));

        //action
        taskService.updateTaskStatus(1L, task2);

        //check
        verify(taskRepository).changeStatus(1L, IN_PROGRESS);
    }
}
