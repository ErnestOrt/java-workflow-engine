package com.ernest.javaworkflowengine.tasks;

import com.ernest.javaworkflowengine.domain.BaseTask;

public class Task2 extends BaseTask {

    @Override
    protected void executeTaskLogic() {
        log.info("Executing Task 2");
    }
}
