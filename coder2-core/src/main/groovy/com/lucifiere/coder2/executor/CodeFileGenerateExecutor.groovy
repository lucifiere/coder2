package com.lucifiere.coder2.executor

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.config.CodeFileGenerateConfig
import com.lucifiere.coder2.executor.config.ExecutorConfig
import com.lucifiere.coder2.executor.container.ExecutorSpec
import com.lucifiere.coder2.executor.req.ExecutorRequest
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.provider.ReTextBizDataProvider
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.templates.CodeTextTemplateResolver
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class CodeFileGenerateExecutor extends AbstractExecutor {

    CodeFileGenerateExecutor() {
        super()
    }

    CodeFileGenerateExecutor(ExecutorConfig context, ExecutorSpec executorSpec) {
        super(context, executorSpec)
    }

    @Override
    ExecResult exec(ExecutorRequest request) {
        CodeFileGenerateConfig context = super.context as CodeFileGenerateConfig

        return null
    }

    @Override
    protected Resolver getResolver(BizDataProvider provider) {
        return new CodeTextTemplateResolver(provider)
    }

    @Override
    protected BizDataProvider getDataProvider() {
        return new ReTextBizDataProvider()
    }

    @Override
    protected void checkContext() {
        CodeFileGenerateConfig context = super.context as CodeFileGenerateConfig
        if (StrUtil.isBlank(context.getTemplatePath())) {
            throw new RuntimeException("code template cant be blank")
        }
        if (StrUtil.isBlank(context.getGeneratedFileName())) {
            throw new RuntimeException("generate file name cant be blank")
        }
    }

}
