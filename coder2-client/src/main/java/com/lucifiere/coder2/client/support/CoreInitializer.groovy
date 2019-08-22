package com.lucifiere.coder2.client.support

import com.lucifiere.coder2.executor.container.ExecutorManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class CoreInitializer {

    @Autowired
    ExecutorManager manager

    final List path = ["com.lucifiere.alibaba"]

    @EventListener(ContextRefreshedEvent.class)
    void containerRegister() {
        manager.registerExecutors(path)
        SpringBootStartSupport.startAllCodeGenerator()
    }

}
