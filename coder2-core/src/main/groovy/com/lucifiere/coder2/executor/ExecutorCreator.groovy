package com.lucifiere.coder2.executor

import cn.hutool.core.map.MapUtil
import cn.hutool.core.util.StrUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ExecutorCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorCreator.class)

    static final String EXECUTOR_TYPE = "executor"

    static final String TEMPLATE_PATH = "templatePath"

    static final String EXECUTOR_NAME = "name"

    static final String FILE_NAME = "generateFileName"

    static final String DDL_PATH = "ddlPath"

    static final String TABLE_PREFIX = "tablePrefix"

    static Executor define(Closure<Map<String, String>> param) {
        Map<String, String> defineMap
        try {
            defineMap = param.call()
        } catch (Exception e) {
            LOGGER.error("invalid define for executor!", e)
            return null
        }
        if (MapUtil.isEmpty(defineMap)) {
            throw new RuntimeException("define map cant be blank!")
        }
        String execType = defineMap.get(ExecutorCreator.EXECUTOR_TYPE)
        if (StrUtil.isEmpty(execType))
            throw new RuntimeException("executor type cant be blank!(executor)")
        String name = defineMap.get(ExecutorCreator.EXECUTOR_NAME)
        if (StrUtil.isEmpty(name))
            throw new RuntimeException("executor name cant be blank!(name)")
        if (execType == CodeFileGenerateExecutor.class.simpleName) {
            return new CodeFileGenerateExecutor(defineMap)
        } else {
            throw new RuntimeException("nonsupport executor type")
        }
    }

}
