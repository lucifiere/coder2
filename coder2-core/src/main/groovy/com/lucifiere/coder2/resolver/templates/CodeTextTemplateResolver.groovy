package com.lucifiere.coder2.resolver.templates

import com.lucifiere.coder2.datasource.FileTextReader
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.resolver.model.ResolverRequest
import com.lucifiere.coder2.resolver.model.TemplateResolverRequest
import com.lucifiere.coder2.resolver.templates.nodes.PhaseNodeUtils
import com.lucifiere.coder2.resolver.templates.nodes.TemplatePhaseNode
import com.lucifiere.coder2.view.View
import com.lucifiere.coder2.view.model.CodeFileView

class CodeTextTemplateResolver extends TemplateResolver {

    CodeTextTemplateResolver(BizDataProvider bizDataProvider) {
        super(bizDataProvider)
    }

    @Override
    View resolve(ResolverRequest request) {
        TemplateResolverRequest templateResolverRequest = request as TemplateResolverRequest
        FileTextReader fileTextReader = new FileTextReader(templateResolverRequest.getTemplatePath())
        List<String> templates = fileTextReader.getText()
        List<TemplatePhaseNode> nodes = PhaseNodeUtils.createTemplatePhaseNodes(templates)
        String res = renderNodes(nodes)
        createView(templateResolverRequest, res)
    }

    static View createView(TemplateResolverRequest request, String content) {
        return new CodeFileView(request.getGenerateFileName(), content)
    }

}
