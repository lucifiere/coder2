package com.lucifiere.coder2.client.xd;

import com.lucifiere.coder2.executor.req.CodeFileGenerateRequest;
import com.lucifiere.coder2.executor.req.ExecutorRequest;
import com.lucifiere.coder2.support.CodeGenerator;
import com.lucifiere.coder2.support.RunWithSpringBoot;
import org.springframework.stereotype.Component;

/**
 * @author XD.Wang
 */
@Component
public class AliPicCodeGenerator extends CodeGenerator {

    public static void main(String[] args) {
        System.out.println(AliPicCodeGenerator.class.isAssignableFrom(CodeGenerator.class));
    }

    @RunWithSpringBoot
    public void aliPic1() {
        CodeFileGenerateRequest.Builder builder = new CodeFileGenerateRequest.Builder();
        super.setCodeFileGeneratorNames("defDao");
        ExecutorRequest request = builder
                .setTablePrefix("coupon_")
                .setDdlFilePath("src/main/resources/templates/damaiDao.cdl")
                .create();
        super.start(request);
    }

}
