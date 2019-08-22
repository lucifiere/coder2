package com.lucifiere.coder2.executor

import com.lucifiere.coder2.executor.req.ExecutorRequest

interface Executor<T> {

    ExecResult<T> exec(ExecutorRequest request)

    String name()

}
