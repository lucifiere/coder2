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

    @RunWithSpringBoot
    public void aliPic1() {
        // 指定模板
        super.setCodeFileGeneratorNames("defDao");
        // 生成入参
        CodeFileGenerateRequest.Builder builder = new CodeFileGenerateRequest.Builder();
        ExecutorRequest request = builder
                .setTablePrefix("coupon_")
                .setDdlFilePath("./coder2-client/src/main/resources/ddl/coupon_template_rule.sql")
                .create();
        super.start(request);
    }

}
