package com.lucifiere.coder2.resolver.templates

import com.lucifiere.coder2.constants.ContentType
import com.lucifiere.coder2.resolver.View

class StaticTemplateView implements View {

    @Override
    ContentType getContentType() { ContentType.CODE_FILE }

    @Override
    String getContent() {
        return null
    }

}
