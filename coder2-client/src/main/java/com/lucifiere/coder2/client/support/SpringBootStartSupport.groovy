package com.lucifiere.coder2.client.support

import com.lucifiere.coder2.helper.ClassPathScanHelper
import com.lucifiere.coder2.support.CodeGenerator
import com.lucifiere.coder2.support.RunWithSpringBoot
import com.lucifiere.coder2.utils.ApplicationContextHolder
import org.springframework.core.annotation.AnnotationUtils

import java.lang.reflect.Method

class SpringBootStartSupport {

    static void startAllCodeGenerator() {
        ClassPathScanHelper handler = new ClassPathScanHelper()
        Set<Class<?>> allClassSet = handler.getPackageAllClasses("com.lucifiere.coder2.client", true)
        allClassSet.each {
            Class curClass = it as Class
            if (CodeGenerator.class.isAssignableFrom(curClass)) {
                curClass.getDeclaredMethods().each {
                    def curMethod = it as Method
                    RunWithSpringBoot define = AnnotationUtils.findAnnotation(curMethod, RunWithSpringBoot.class)
                    if (define != null) {
                        println "执行" + curClass.simpleName + "::" + curMethod.name
                        Object invoker = ApplicationContextHolder.ins().getBean(curClass)
                        curMethod.invoke(invoker)
                    }
                }
            }
        }
    }

}
