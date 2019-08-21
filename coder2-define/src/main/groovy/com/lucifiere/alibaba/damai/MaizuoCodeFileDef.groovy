package com.lucifiere.alibaba.damai

import com.lucifiere.coder2.executor.CodeFileGenerateExecutor
import com.lucifiere.coder2.executor.context.CodeFileExecutorContext
import com.lucifiere.coder2.executor.container.ExecutorDef
import com.lucifiere.coder2.executor.container.ExecutorGroup

@ExecutorGroup
class MaizuoCodeFileDef {

    @ExecutorDef
    CodeFileExecutorContext defDao() {
        CodeFileExecutorContext.Builder builder = new CodeFileExecutorContext.Builder()
        return builder.setTablePrefix("coupon_")
                .setDdlFilePath("src/test/resources/ddl/coupon_template_rule.sql")
                .setGeneratedFileName("x")
                .setTemplatePath("src/test/resources/templates/damaiDao.cdl")
                .setExecutorClazz(CodeFileGenerateExecutor.class)
                .setName("defDao")
                .create()
    }

}
