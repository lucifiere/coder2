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
            new File(path).readLines()
        } catch (Exception ignored) {
            throw new RuntimeException("文件读取失败，请检查路径是否正确： " + path)
        }
    }

}
