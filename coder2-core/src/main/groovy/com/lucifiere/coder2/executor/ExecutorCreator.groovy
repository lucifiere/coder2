package com.lucifiere.coder2.executor

class ExecutorCreator {

    static final String EXECUTOR_TYPE = "executor"

    static final String TEMPLATE_PATH = "templatePath"

    static final String FILE_NAME = "fileName"

    static final String DDL_PATH = "ddlPath"

    static final String TABLE_PREFIX = "tablePrefix"

    static Executor define(Closure<Map<String, String>> param) {
        Map<String, String> map = param.call()

    }

}
