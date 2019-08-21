package com.lucifiere.alibaba.damai

import com.lucifiere.coder2.executor.CodeFileGenerateExecutor
import com.lucifiere.coder2.executor.container.ExecutorDef
import com.lucifiere.coder2.executor.container.ExecutorGroup
import com.lucifiere.coder2.executor.context.CodeFileExecutorContext

@ExecutorGroup
class MaizuoCodeFileDef {

    @ExecutorDef(name = "defDao", clazz = CodeFileGenerateExecutor.class)
    CodeFileExecutorContext defDao() {
        CodeFileExecutorContext.Builder builder = new CodeFileExecutorContext.Builder()
        builder.setTablePrefix("coupon_")
                .setDdlFilePath("src/main/resources/ddl/coupon_template_rule.sql")
                .setGeneratedFileName("x")
                .setTemplatePath("src/main/resources/templates/damaiDao.cdl")
                .create()
    }

}
