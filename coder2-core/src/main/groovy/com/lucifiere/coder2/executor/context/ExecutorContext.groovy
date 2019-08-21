package com.lucifiere.coder2.executor.context

interface ExecutorContext<T> {

    Class<T> getExecutorClazz()

    String getName()

}