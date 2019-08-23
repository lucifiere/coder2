package com.lucifiere.coder2.view.model

import com.lucifiere.coder2.constants.ContentType
import com.lucifiere.coder2.view.View

class CodeFileView implements View {

    private String fileName

    private String fileContent

    CodeFileView(String fileName, String fileContent) {
        this.fileName = fileName
        this.fileContent = fileContent
    }

    @Override
    ContentType getContentType() { ContentType.CODE_FILE }

    @Override
    String getContent() {
        return fileContent
    }

    @Override
    String toString() {
        return "CodeFileView{" +
                "fileName='" + fileName + '\'' +
                ", fileContent=\n'" + fileContent + '\'' +
                '}'
    }
}
