package com.lucifiere.coder2.executor

import com.lucifiere.coder2.executor.req.ExecutorRequest

interface Executor {

    ExecResult exec(ExecutorRequest request)

    String name()

}
