package com.lucifiere.coder2.utils

import cn.hutool.core.util.StrUtil
import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class ApplicationContextHolder implements ApplicationContextAware {

    /**
     * spring application config.
     */
    private static ApplicationContext context

    /**
     * Sets application config.
     *
     * @param context the config
     * @throws BeansException the beans exception
     */
    @Override
    void setApplicationContext(ApplicationContext context) throws BeansException {
        ApplicationContextHolder.context = context
    }

    static ApplicationContext ins() {
        context
    }

    /**
     * get spring bean via name.
     *
     * @param <T >        the generic of the spring bean.
     * @param beanName the bean's name.
     * @return the found spring bean.
     */
    static <T> T getSpringBean(String beanName) {
        StrUtil.isNotBlank(beanName)
        if (null == context) {
            return null
        }
        return (T) context.getBean(beanName)
    }

}
