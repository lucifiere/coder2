package com.lucifiere.coder2.executor

import cn.hutool.core.util.ObjectUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.context.CodeFileExecutorContext
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.resolver.Resolver

abstract class AbstractExecutor implements Executor {

    protected String name

    protected Resolver resolver

    protected BizDataProvider bizDataProvider

    protected CodeFileExecutorContext context

    protected abstract Resolver getResolver(BizDataProvider provider)

    protected abstract BizDataProvider getDataProvider()

    protected abstract void checkContext(CodeFileExecutorContext context)

    @Override
    String name() {
        return name
    }

    protected void checkContext0(CodeFileExecutorContext context) {
        if (StrUtil.isBlank(context.getName())) {
            throw new RuntimeException("executor name cant be blank")
        }
        if (ObjectUtil.isNull(context.getExecutorClazz())) {
            throw new RuntimeException("executor clazz cant be null")
        }
        checkContext()
    }

    AbstractExecutor(CodeFileExecutorContext context) {
        checkContext0(context)
        this.context = context
        this.name = context.getName()
        this.bizDataProvider = getDataProvider()
        this.resolver = getResolver(this.bizDataProvider)
    }

}
