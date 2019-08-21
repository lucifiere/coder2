package com.lucifiere.coder2


import com.lucifiere.coder2.executor.context.CodeFileExecutorContext
import org.junit.Test

class ExecutorTest {

    @Test
    void testExecutorBuilderFunc() {
        CodeFileExecutorContext.Builder<String> builder = new CodeFileExecutorContext.Builder<String>()
        builder.setExecutorClazz(String.class)
        CodeFileExecutorContext x = builder.create()
        String a = x.getExecutorClazz().newInstance()
        print(a)
    }

}
