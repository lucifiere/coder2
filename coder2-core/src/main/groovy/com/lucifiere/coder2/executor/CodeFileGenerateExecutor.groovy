package com.lucifiere.coder2.executor

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.executor.config.CodeFileGenerateConfig
import com.lucifiere.coder2.executor.config.ExecutorConfig
import com.lucifiere.coder2.executor.container.ExecutorSpec
import com.lucifiere.coder2.executor.req.CodeFileGenerateRequest
import com.lucifiere.coder2.executor.req.ExecutorRequest
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.provider.ReTextBizDataProvider
import com.lucifiere.coder2.provider.model.TextBizDataRequest
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.model.ResolverRequest
import com.lucifiere.coder2.resolver.model.TemplateResolverRequest
import com.lucifiere.coder2.resolver.templates.CodeTextTemplateResolver
import com.lucifiere.coder2.view.CodeFileViewProcessor
import com.lucifiere.coder2.view.View
import com.lucifiere.coder2.view.ViewProcessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class CodeFileGenerateExecutor<T> extends AbstractExecutor<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeFileGenerateExecutor.class)

    @Override
    void processView(View view) {
        ViewProcessor viewProcessor = new CodeFileViewProcessor()
        viewProcessor.process(view)
    }

    @Override
    BizDataContent getBizDataContent(ExecutorRequest request) {
        CodeFileGenerateRequest cfRequest = request as CodeFileGenerateRequest
        BizDataProvider dataProvider = new ReTextBizDataProvider()
        TextBizDataRequest bizDataRequest = new TextBizDataRequest()
        bizDataRequest.setTablePrefix(cfRequest.getTablePrefix())
        bizDataRequest.setTextFilePath(cfRequest.getDdlFilePath())
        dataProvider.getContent(bizDataRequest)
    }

    @Override
    View resolve(BizDataContent bizDataContent) {
        CodeFileGenerateConfig context = context as CodeFileGenerateConfig
        ResolverRequest resolverRequest = new TemplateResolverRequest()
        resolverRequest.setTemplatePath(context.getTemplatePath())
        resolverRequest.setGenerateFileName(context.getGeneratedFileName())
        Resolver resolver = new CodeTextTemplateResolver(bizDataContent)
        resolver.resolve(resolverRequest)
    }

    CodeFileGenerateExecutor() {
        super()
    }

    CodeFileGenerateExecutor(ExecutorConfig context, ExecutorSpec executorSpec) {
        super(context, executorSpec)
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
