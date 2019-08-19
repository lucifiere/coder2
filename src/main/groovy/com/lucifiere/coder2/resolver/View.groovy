package com.lucifiere.coder2.resolver

import com.lucifiere.coder2.constants.ContentType

interface View {

    ContentType getContentType()

    String getContent()

}
