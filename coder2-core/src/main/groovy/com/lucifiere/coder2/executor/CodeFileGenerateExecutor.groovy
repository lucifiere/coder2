package com.lucifiere.coder2.executor

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.context.CodeFileExecutorContext
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.provider.ReTextBizDataProvider
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.templates.CodeTextTemplateResolver

class CodeFileGenerateExecutor extends AbstractExecutor {

    CodeFileGenerateExecutor(CodeFileExecutorContext context) {
        super(context)
    }

    @Override
    ExecResult exec() {
        return null
    }

    @Override
    protected Resolver getResolver(BizDataProvider provider) {
        return new CodeTextTemplateResolver(context.getTemplatePath(), context.getGeneratedFileName(), provider)
    }

    @Override
    protected BizDataProvider getDataProvider() {
        return new ReTextBizDataProvider(context.getDdlFilePath(), context.toTextBizDataSourceContext())
    }

    @Override
    protected void checkContext(CodeFileExecutorContext context) {
        if (StrUtil.isBlank(context.getDdlFilePath())) {
            throw new RuntimeException("ddl path cant be blank")
        }
        if (StrUtil.isBlank(context.getTemplatePath())) {
            throw new RuntimeException("code template cant be blank")
        }
        if (StrUtil.isBlank(context.getGeneratedFileName())) {
            throw new RuntimeException("generate file name cant be blank")
        }
    }

}
