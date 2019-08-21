package com.lucifiere.coder2.executor.container

import cn.hutool.core.annotation.AnnotationUtil
import cn.hutool.core.util.ObjectUtil
import com.lucifiere.coder2.executor.Executor
import com.lucifiere.coder2.executor.context.ExecutorContext
import com.lucifiere.coder2.helper.ClassPathScanHelper
import org.springframework.core.annotation.AnnotationUtils

import java.lang.reflect.Constructor
import java.lang.reflect.Method

class ExecutorContainer {

    private List<Executor> executors = []

    private Map<String, Executor> executorMap = [:]

    Executor getExecutor(String name) {
        return executorMap.get(name)
    }

    synchronized void scanAndRegister(List<String> path) {
        ClassPathScanHelper handler = new ClassPathScanHelper()
        Set<Class<?>> allClassSet = new TreeSet<>()
        for (String classPackage : path) {
            allClassSet.addAll(handler.getPackageAllClasses(classPackage, true));
        }
        register(allClassSet)
    }

    private void register(Set<Class<?>> classes) {
        classes.each {
            Class curClass = it as Class
            ExecutorGroup group = AnnotationUtils.findAnnotation(curClass, ExecutorGroup.class)
            if (group != null) {
                [AnnotationUtil.getDeclaredMethods()].each {
                    def curMethod = it as Method
                    ExecutorDef define = AnnotationUtils.findAnnotation(curMethod, ExecutorDef.class)
                    if (define != null) {
                        ExecutorSpec spec = ExecutorSpec.of(define)
                        Object object = curMethod.invoke(curClass)
                        if (object instanceof ExecutorContext) {
                            ExecutorContext context = object as ExecutorContext
                            registerExecutor(context, spec)
                        }
                    }
                }
            }
        }
    }

    private synchronized void registerExecutor(ExecutorContext context, ExecutorSpec spec) {
        if (ObjectUtil.isNull(context)) {
            throw new RuntimeException("register failed cause context cant be null")
        }
        def executorClazz = spec.getClazz()
        Constructor<Executor> executorConstructor = executorClazz.getConstructor(ExecutorContext.class, ExecutorSpec.class)
        Executor executor = executorConstructor.newInstance(context, spec) as Executor
        executorMap.putIfAbsent(spec.name, executor)
        executors << executor
    }

}
