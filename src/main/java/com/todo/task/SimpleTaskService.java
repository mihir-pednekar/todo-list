package com.todo.task;

import com.todo.utils.ToDoConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimpleTaskService implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> viewTasks() {
        return Optional.of(taskRepository.findAll())
                .map(tasks -> tasks.stream()
                    .filter(task -> task.getStatus().equals(ToDoConstants.TASK_STATUS_OPEN) &&
                            task.getStatus().equals(ToDoConstants.TASK_STATUS_CLOSED))
                    .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public boolean addTask(Task task) {
        if(task!=null){
            log.info("Task with title {} is created.", task.getTitle());
            taskRepository.save(task);
            return true;
        }
        else{
            log.error("Task cannot be null.");
            return false;
        }
    }

    @Override
    public boolean closeTask(Task task) {
        return false;
    }
}
