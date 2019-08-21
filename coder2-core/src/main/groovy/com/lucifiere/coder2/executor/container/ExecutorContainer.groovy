package com.lucifiere.coder2.executor.container

import cn.hutool.core.util.ObjectUtil
import com.lucifiere.coder2.executor.Executor
import com.lucifiere.coder2.executor.context.ExecutorContext

import java.lang.reflect.Constructor

class ExecutorContainer {

    private List<Executor> executors = []

    private Map<String, Executor> executorMap = [:]

    private void registerExecutor(ExecutorContext context, ExecutorSpec spec) {
        if (ObjectUtil.isNull(context)) {
            throw new RuntimeException("register failed cause context cant be null")
        }
        def executorClazz = spec.getClazz()
        Constructor<Executor> executorConstructor = executorClazz.getConstructor(ExecutorContext.class, ExecutorSpec.class)
        Executor executor = executorConstructor.newInstance(context, spec) as Executor
        executorMap.putIfAbsent(spec.name, executor)
        executors << executor
    }

    private Executor getExecutor(String name) {
        return executorMap.get(name)
    }

    void scanAndRegister(String[] path) {

    }

}
