package com.lucifiere.coder2.executor.container

import com.lucifiere.coder2.executor.Executor

class ExecutorSpec<T extends Executor> {

    private String name

    private Class<T> clazz

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Class<T> getClazz() {
        return clazz
    }

    void setClazz(Class<T> clazz) {
        this.clazz = clazz
    }

    static ExecutorSpec of(ExecutorDef define) {
        ExecutorSpec spec = new ExecutorSpec()
        spec.setName(define.name())
        spec.setClazz(define.clazz())
        spec
    }

}
