package com.lucifiere.coder2.executor.container

import com.lucifiere.coder2.executor.Executor

class ExecutorManager {

    private ExecutorManager() {}

    /**
     * instance.
     */
    private static volatile ExecutorManager instance = null

    private static ExecutorContainer executorContainer = new ExecutorContainer()

    /**
     * Gets instance.
     *
     * @return get the instance.
     */
    static ExecutorManager getInstance() {
        if (instance == null) {
            synchronized (ExecutorManager.class) {
                if (instance == null) {
                    instance = new ExecutorManager()
                }
            }
        }
        return instance
    }

    void registerExecutors(List<String> path) {
        executorContainer.scanAndRegister(path)
    }

    Executor getExecutor(String name) {
        return executorContainer.getExecutor(name)
    }

}
