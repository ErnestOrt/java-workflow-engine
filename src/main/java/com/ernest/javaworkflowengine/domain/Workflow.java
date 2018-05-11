package com.ernest.javaworkflowengine.domain;

public class Workflow {

    TaskPath taskPath;

    public Workflow(TaskPath taskPath) {
        this.taskPath = taskPath;
    }

    public TaskPath getTaskPath() {
        return taskPath;
    }

    public void execute() {
        taskPath.getTasks().forEach(task -> task.execute());
    }
}
