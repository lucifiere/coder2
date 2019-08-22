package com.lucifiere.coder2.client.runner;

import com.google.common.collect.Lists;
import com.lucifiere.coder2.executor.ExecResult;
import com.lucifiere.coder2.executor.Executor;
import com.lucifiere.coder2.executor.container.ExecutorManager;
import com.lucifiere.coder2.executor.req.ExecutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 代码生成
 *
 * @author XD.Wang
 */
@Component
public class CodeGenerator {

    @Autowired
    private ExecutorManager executorManager;

    private List<String> executorNames = Lists.newArrayList();

    public CodeGenerator() {
    }

    public void setCodeFileGeneratorNames(String... names) {
        executorNames.addAll(Arrays.asList(names));
    }

    public void start(ExecutorRequest request) {
        executorNames.forEach(executorName -> {
            Executor executor = executorManager.getExecutor(executorName);
            ExecResult result = executor.exec(request);
            System.out.println(result);
        });
    }

}
