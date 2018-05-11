package com.ernest.javaworkflowengine.tasks;

import com.ernest.javaworkflowengine.domain.BaseTask;

public class Task1 extends BaseTask {

    @Override
    protected void executeTaskLogic() {
        log.info("Executing Task 1");
    }
}
