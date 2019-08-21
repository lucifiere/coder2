package com.lucifiere.coder2.executor.container


import com.lucifiere.coder2.executor.Executor
import org.springframework.util.CollectionUtils

class ExecutorManager {

    private ExecutorManager() {}

    /**
     * instance.
     */
    private static volatile ExecutorManager instance = null

    private ExecutorContainer executorContainer = new ExecutorContainer()

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
        if (CollectionUtils.isEmpty(path)) throw new RuntimeException("executor register package path cant be blank")
        executorContainer.scanAndRegister(path)
    }

    Executor getExecutor(String name) {
        return executorContainer.getExecutor(name)
    }

}
