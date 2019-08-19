package com.lucifiere.coder2.resolver.view

import com.lucifiere.coder2.constants.ContentType
import com.lucifiere.coder2.resolver.view.View

class CodeFileView implements View {

    @Override
    ContentType getContentType() { ContentType.CODE_FILE }

    @Override
    String getContent() {
        return null
    }

}
