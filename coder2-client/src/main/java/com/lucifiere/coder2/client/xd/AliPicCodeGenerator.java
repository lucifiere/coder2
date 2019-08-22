package com.lucifiere.coder2.client.xd;

import com.lucifiere.coder2.client.runner.CodeGenerator;
import com.lucifiere.coder2.client.runner.RunWithSpringBoot;
import com.lucifiere.coder2.executor.req.CodeFileGenerateRequest;
import com.lucifiere.coder2.executor.req.ExecutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author XD.Wang
 */
@Component
public class AliPicCodeGenerator {

    @Autowired
    private CodeGenerator codeGenerator;

    @RunWithSpringBoot
    public void aliPic1() {
        CodeFileGenerateRequest.Builder builder = new CodeFileGenerateRequest.Builder();
        codeGenerator.setCodeFileGeneratorNames("defDao");
        ExecutorRequest request = builder.setTablePrefix("coupon_")
                .setDdlFilePath("src/main/resources/templates/damaiDao.cdl")
                .create();
        codeGenerator.start(request);
    }

}
