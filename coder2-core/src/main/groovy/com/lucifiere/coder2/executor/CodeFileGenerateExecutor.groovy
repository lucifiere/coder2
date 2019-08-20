package com.lucifiere.coder2.executor

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.provider.ReTextBizDataProvider
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.templates.CodeTextTemplateResolver

class CodeFileGenerateExecutor extends AbstractExecutor {

    CodeFileGenerateExecutor(Map<String, String> defineMap) {
        super(defineMap)
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

    ExecutorContext getContext(Map<String, String> defineMap) {
        String templatePath = defineMap.get(ExecutorCreator.TEMPLATE_PATH)
        if (StrUtil.isEmpty(templatePath))
            throw new RuntimeException("template path cant be blank!(templatePath)")
        String fileName = defineMap.get(ExecutorCreator.FILE_NAME)
        if (StrUtil.isEmpty(fileName))
            throw new RuntimeException("file name cant be blank!(fileName)")
        String ddlPath = defineMap.get(ExecutorCreator.DDL_PATH)
        if (StrUtil.isEmpty(ddlPath))
            throw new RuntimeException("ddl path cant be blank!(ddlPath)")
        String tablePrefix = defineMap.get(ExecutorCreator.TABLE_PREFIX)
        ExecutorContext.Builder builder = new ExecutorContext.Builder()
        builder.setTablePrefix(tablePrefix).setGeneratedFileName(fileName).setTemplatePath(templatePath).setDdlFilePath(ddlPath).create()
    }

}
