package com.lucifiere.coder2.datasource

import cn.hutool.core.util.StrUtil

import java.util.stream.Collectors

class FileTextReader implements TextDatasource {

    private String path

    FileTextReader(String path) {
        this.path = path
    }

    @Override
    List<String> getText() {
        try {
            List<String> lines = new File(path).readLines()
            lines.stream().map {
                StrUtil.trim(it)
            }.collect(Collectors.toList())
        } catch (Exception ignored) {
            return null
        }
    }

}
