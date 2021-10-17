package com.todo.task;

import java.util.List;

public interface TaskService {

    List<Task> viewTasks();

    boolean addTask(Task task);

    boolean closeTask(Task task);
}
