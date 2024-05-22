package org.example.bean;

import lombok.NoArgsConstructor;


public class CodeGeneratorImpl implements CodeGenerator {
    @Override
    public String generateTestCode(String input) {
        return input + "\n    // 测试代码生成逻辑\n}";
    }
}
