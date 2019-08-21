package com.lucifiere.coder2.helper


import com.lucifiere.coder2.executor.container.ExecutorManager
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class InitRegister {

    final List path = ["com.lucifiere.alibaba"]

    @EventListener(ContextRefreshedEvent.class)
    void containerRegister() {
        ExecutorManager manager = ExecutorManager.getInstance()
        manager.registerExecutors(path)
    }

}
