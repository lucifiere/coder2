package com.lucifiere.coder2.executor

import cn.hutool.core.util.ObjectUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.config.ExecutorConfig
import com.lucifiere.coder2.executor.container.ExecutorSpec
import com.lucifiere.coder2.executor.req.ExecutorRequest
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.view.View

abstract class AbstractExecutor<T> implements Executor<T> {

    protected String name

    protected ExecutorConfig context

    protected abstract void checkContext()

    @Override
    ExecResult<T> exec(ExecutorRequest request) {
        try {
            BizDataContent bizDataContent = getBizDataContent(request)
            View view = resolve(bizDataContent)
            processView(view)
            return ExecResult.suc(view.getContent())
        } catch (Exception e) {
            println e
//            return ExecResult.fail(e.getMessage())
            throw e
        }
    }

    protected abstract BizDataContent getBizDataContent(ExecutorRequest request)

    protected abstract View resolve(BizDataContent bizDataContent)

    protected abstract void processView(View view)

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
    }

}
