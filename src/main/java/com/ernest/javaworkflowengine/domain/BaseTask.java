package com.ernest.javaworkflowengine.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTask implements Task{

    protected final Logger log = LoggerFactory.getLogger(BaseTask.class);

    private static final int SUCCESS_CODE = 1;
    private static final int ERROR_CODE = 0;

    List<Task> parallelTasks = new ArrayList<>();

    Date startingTime;
    Date completedTime;

    public BaseTask addParallelTasks(Task task){
        parallelTasks.add(task);
        return this;
    }

    @Override
    public Date getStartingTime() {
        return startingTime;
    }

    @Override
    public Date getCompletedTime() {
        return completedTime;
    }

    @Override
    public Integer execute() throws RuntimeException {
        Map<String, CompletableFuture<Integer>> futuresMap = executeParallelTasks();

        startingTime = new Date();
        executeTaskLogic();
        completedTime = new Date();

        try {
            for (String key : futuresMap.keySet()) {
                if (futuresMap.get(key).get() != SUCCESS_CODE) throw new InterruptedException();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ERROR_CODE;
        }

        return SUCCESS_CODE;
    }

    private Map<String, CompletableFuture<Integer>> executeParallelTasks(){
        Map<String, CompletableFuture<Integer>> futuresMap =  new HashMap<>();
        parallelTasks.forEach(parallelTask -> futuresMap.put(UUID.randomUUID().toString(), CompletableFuture.supplyAsync(() -> parallelTask.execute())));
        return futuresMap;
    }

    protected abstract void executeTaskLogic();

}
