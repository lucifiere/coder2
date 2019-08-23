package com.lucifiere.coder2.support

import com.google.common.collect.Lists
import com.lucifiere.coder2.executor.ExecResult
import com.lucifiere.coder2.executor.Executor
import com.lucifiere.coder2.executor.container.ExecutorManager
import com.lucifiere.coder2.executor.req.ExecutorRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * 代码生成
 *
 * @author XD.Wang
 */
@Component
class CodeGenerator {

    @Autowired
    private ExecutorManager executorManager

    private List<String> executorNames = Lists.newArrayList()

    ExecutorManager getExecutorManager() {
        return executorManager
    }

    void setExecutorManager(ExecutorManager executorManager) {
        this.executorManager = executorManager
    }

    List<String> getExecutorNames() {
        return executorNames
    }

    void setExecutorNames(List<String> executorNames) {
        this.executorNames = executorNames
    }

    CodeGenerator() {
    }

    void setCodeFileGeneratorNames(String... names) {
        executorNames.addAll(Arrays.asList(names))
    }

    void start(ExecutorRequest request) {
        executorNames.forEach {
            Executor executor = executorManager.getExecutor(it)
            ExecResult result = executor.exec(request)
            System.out.println(result)
        }
    }

}
