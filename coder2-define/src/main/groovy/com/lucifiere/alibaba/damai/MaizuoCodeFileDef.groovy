package com.lucifiere.alibaba.damai

import com.lucifiere.coder2.executor.CodeFileGenerateExecutor
import com.lucifiere.coder2.executor.config.CodeFileGenerateConfig
import com.lucifiere.coder2.executor.container.ExecutorDef
import com.lucifiere.coder2.executor.container.ExecutorGroup

@ExecutorGroup
class MaizuoCodeFileDef {

    @ExecutorDef(name = "defDao", clazz = CodeFileGenerateExecutor.class)
    CodeFileGenerateConfig defDao() {
        CodeFileGenerateConfig.Builder builder = new CodeFileGenerateConfig.Builder()
        builder.setTemplatePath("src/main/resources/templates/damaiDao.cdl")
                .setGeneratedFileName("xx")
                .create()
    }

}
