package com.lucifiere.coder2.executor

import cn.hutool.core.util.ObjectUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.config.ExecutorConfig
import com.lucifiere.coder2.executor.container.ExecutorSpec
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.resolver.Resolver

abstract class AbstractExecutor implements Executor {

    protected String name

    protected Resolver resolver

    protected BizDataProvider bizDataProvider

    protected ExecutorConfig context

    protected abstract BizDataProvider getDataProvider()

    protected abstract getResolver(BizDataProvider provider)

    protected abstract void checkContext()

    @Override
    String name() {
        return name
    }

    private static void checkExecutorSpec(ExecutorSpec executorSpec) {
        if (StrUtil.isBlank(executorSpec.getName())) {
            throw new RuntimeException("executor name cant be blank")
        }
        if (ObjectUtil.isNull(executorSpec.getClazz())) {
            throw new RuntimeException("executor clazz cant be null")
        }
    }

    AbstractExecutor() {
        throw new UnsupportedOperationException("com.lucifiere.coder2.executor.Executor is not supported autowire!")
    }

    AbstractExecutor(ExecutorConfig context, ExecutorSpec executorSpec) {
        checkExecutorSpec(executorSpec)
        this.context = context
        checkContext()
        this.name = executorSpec.getName()
        this.bizDataProvider = getDataProvider()
        this.resolver = getResolver()
    }

}
