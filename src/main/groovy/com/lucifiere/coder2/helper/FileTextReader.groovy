package com.lucifiere.coder2.helper

class FileTextReader implements TextReader {

    private String path

    FileTextReader(String path) {
        this.path = path
    }

    @Override
    List<String> getText() {
        try {
            return new File(path).readLines()
        } catch (Exception ignored) {
            return null
        }
    }

}
