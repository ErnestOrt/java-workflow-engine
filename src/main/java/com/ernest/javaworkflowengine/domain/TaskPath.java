package com.ernest.javaworkflowengine.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskPath {

    List<Task> tasks = new ArrayList<>();

    public TaskPath addTask(Task task){
        tasks.add(task);
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
