package com.lucifiere.coder2

import com.lucifiere.coder2.executor.container.ExecutorManager
import org.junit.Test

class ExecutorManagerTests {

    @Test
    void testRegister() {
        ExecutorManager executorManager = ExecutorManager.getInstance()
        executorManager.registerExecutors(["com.lucifiere.alibaba"])
    }

}
