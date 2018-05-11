# Java Workflow Engine

Is an open-source, powerful, light-weight, and easily configurable workflow engine.

In contrast to many other Java-based workflow engines, it is not only written in 100% pure Java but it also uses Java for workflow definitions.

Having this core, you will be able to define as many Java tasks as you need!

## How Can I Build a Workflow?

To create your own workflow follow these steps:

1. Inside `com.ernest.javaworkflowengine.tasks` create your tasks extending them from the `BaseTask`. Doing that, you will have to *Override* `executeTaskLogic` method. Is here where you have to set the *business logic*. Once you have created all your tasks, you are ready to define your own worflow.

```java
public class Task1 extends BaseTask {

    @Override
    protected void executeTaskLogic() {
        log.info("Executing Task 1");
    }
}
```

2. Inside `com.ernest.javaworkflowengine.workflows` create your new workflow builder implementing the `WorkflowBuilder` interface. Here you will have to define a TaskPath as follows:

```java
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
```

3. Now everything is ready to start your own workflow!

```java
  Workflow workflow = new WorkflowExampleBuilder().build();
  workflow.execute();
```

### Contributing
Start Admin Spring Boot locally and then click the star button to make the author and his neighbors happy :blush:. Then fork the repository and submit a pull request for whatever change you want to be added to this project.

If you have any questions or improvement proposal, just open an issue.

# Enjoy it Folks!
