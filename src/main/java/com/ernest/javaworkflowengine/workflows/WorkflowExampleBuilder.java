package com.ernest.javaworkflowengine.workflows;

import com.ernest.javaworkflowengine.domain.TaskPath;
import com.ernest.javaworkflowengine.domain.Workflow;
import com.ernest.javaworkflowengine.tasks.Task1;
import com.ernest.javaworkflowengine.tasks.Task12;
import com.ernest.javaworkflowengine.tasks.Task13;
import com.ernest.javaworkflowengine.tasks.Task14;
import com.ernest.javaworkflowengine.tasks.Task2;

public class WorkflowExampleBuilder implements WorkflowBuilder{

    @Override
    public Workflow build() {
        TaskPath taskPath = new TaskPath()
                .addTask(new Task1()
                        .addParallelTasks(new Task12())
                        .addParallelTasks(new Task13())
                        .addParallelTasks(new Task14()))
                .addTask(new Task2());

        return new Workflow(taskPath);
    }
}
