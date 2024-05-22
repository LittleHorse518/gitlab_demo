package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class LamdaMethod {
    public Convert convert = new Convert();
    public Integer filterAndTransform(List<String> input) {

        List<String> arr = input.stream()
                .filter(str -> str.startsWith("A"))
                .filter(str -> convert.checkPwd(str))
                .collect(Collectors.toList());
        return arr.size();
    }

    public List<String> processData(List<String> input) {
        List<String> result = input.stream()
                .filter(s -> s != null && !s.isEmpty())
                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("A"))
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}
