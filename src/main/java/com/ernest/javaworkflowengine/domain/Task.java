package com.ernest.javaworkflowengine.domain;

import java.util.Date;

public interface Task {

    Integer execute();
    Date getStartingTime();
    Date getCompletedTime();
}
