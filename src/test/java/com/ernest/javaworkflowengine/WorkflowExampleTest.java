package com.ernest.javaworkflowengine;

import com.ernest.javaworkflowengine.domain.Workflow;
import com.ernest.javaworkflowengine.workflows.WorkflowExampleBuilder;
import org.junit.Assert;
import org.junit.Test;

public class WorkflowExampleTest {

    @Test
    public void GIVEN_WorkflowExample_WHEN_ExecutingIt_THEN_EverythingIsFine(){
        Workflow workflow = new WorkflowExampleBuilder().build();

        Assert.assertTrue(workflow.getTaskPath().getTasks().stream().allMatch(task -> task.getStartingTime() == null));
        Assert.assertTrue(workflow.getTaskPath().getTasks().stream().allMatch(task -> task.getCompletedTime() == null));

        workflow.execute();

        Assert.assertTrue(workflow.getTaskPath().getTasks().stream().allMatch(task -> task.getStartingTime() != null));
        Assert.assertTrue(workflow.getTaskPath().getTasks().stream().allMatch(task -> task.getCompletedTime() != null));
    }
}
