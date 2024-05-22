package org.example;

import java.util.concurrent.CompletableFuture;

public class AsyncMethod {

    public CompletableFuture<String> fetchDataAsync() {
        CompletableFuture<String> future = new CompletableFuture<>();
        // 模拟异步操作，例如从网络获取数据

        return future;
    }
}
