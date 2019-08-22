package com.lucifiere.coder2.executor.container

import cn.hutool.core.util.ObjectUtil
import com.lucifiere.coder2.executor.Executor
import com.lucifiere.coder2.executor.config.ExecutorConfig
import com.lucifiere.coder2.helper.ClassPathScanHelper
import com.lucifiere.coder2.utils.ApplicationContextHolder
import org.springframework.core.annotation.AnnotationUtils

import java.lang.reflect.Method

class ExecutorContainer {

    private List<Executor> executors = []

    private Map<String, Executor> executorMap = [:]

    Executor getExecutor(String name) {
        return executorMap.get(name)
    }

    synchronized void scanAndRegister(List<String> path) {
        ClassPathScanHelper handler = new ClassPathScanHelper()
        Set<Class<?>> allClassSet = new HashSet<>()
        for (String classPackage : path) {
            allClassSet.addAll(handler.getPackageAllClasses(classPackage, true))
        }
        register(allClassSet)
    }

    private void register(Set<Class<?>> classes) {
        classes.each {
            Class curClass = it as Class
            ExecutorGroup group = AnnotationUtils.findAnnotation(curClass, ExecutorGroup.class)
            if (group != null && !group.skip()) {
                curClass.getDeclaredMethods().each {
                    def curMethod = it as Method
                    ExecutorDef define = AnnotationUtils.findAnnotation(curMethod, ExecutorDef.class)
                    if (define != null) {
                        ExecutorSpec spec = ExecutorSpec.of(define)
                        Object object = curMethod.invoke(curClass.newInstance())
                        if (object instanceof ExecutorConfig) {
                            ExecutorConfig context = object as ExecutorConfig
                            registerExecutor(context, spec)
                        }
                    }
                }
            }
        }
    }

    private synchronized void registerExecutor(ExecutorConfig context, ExecutorSpec spec) {
        if (ObjectUtil.isNull(context)) {
            throw new RuntimeException("register failed cause config cant be null")
        }
        def executorClazz = spec.getClazz()
        Executor e = ApplicationContextHolder.ins().getBean(executorClazz, context, spec) as Executor
        executorMap.putIfAbsent(spec.name, e)
        executors << e
    }

}
