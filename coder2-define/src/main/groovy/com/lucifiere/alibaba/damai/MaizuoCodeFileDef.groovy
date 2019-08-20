package com.lucifiere.alibaba.damai

import com.lucifiere.coder2.executor.CodeFileGenerateExecutor
import com.lucifiere.coder2.executor.container.ExecutorDef
import com.lucifiere.coder2.executor.container.ExecutorGroup

@ExecutorGroup
class MaizuoCodeFileDef {

    @ExecutorDef
    Map<String, String> daoDef() {
        [
                "executor"        : CodeFileGenerateExecutor.class.simpleName,
                "templatePath"    : "src/test/resources/templates/damaiDao.cdl",
                "ddlPath"         : "src/test/resources/ddl/coupon_template_rule.sql",
                "name"            : "damai-dao-def",
                "generateFileName": "xx",
                "tablePrefix"     : "coupon_"
        ]
    }

}
