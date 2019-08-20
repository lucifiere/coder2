package com.lucifiere.coder2.executor

import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.resolver.Resolver

abstract class AbstractExecutor implements Executor {

    protected Resolver resolver

    protected BizDataProvider bizDataProvider

    protected ExecutorContext context

    protected abstract Resolver getResolver(BizDataProvider provider)

    protected abstract BizDataProvider getDataProvider()

    protected abstract ExecutorContext getContext(Map<String, String> defineMap)

    AbstractExecutor(Map<String, String> defineMap) {
        this.context = getContext(defineMap)
        this.bizDataProvider = getDataProvider()
        this.resolver = getResolver(this.bizDataProvider)
    }

}
