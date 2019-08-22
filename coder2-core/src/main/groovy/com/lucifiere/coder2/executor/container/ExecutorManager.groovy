package com.lucifiere.coder2.executor.container

import com.lucifiere.coder2.executor.Executor
import org.springframework.stereotype.Component
import org.springframework.util.CollectionUtils

@Component
class ExecutorManager {

    ExecutorManager() {}

    private ExecutorContainer executorContainer = new ExecutorContainer()

    void registerExecutors(List<String> path) {
        if (CollectionUtils.isEmpty(path)) throw new RuntimeException("executor register package path cant be blank")
        executorContainer.scanAndRegister(path)
    }

    Executor getExecutor(String name) {
        return executorContainer.getExecutor(name)
    }

}
