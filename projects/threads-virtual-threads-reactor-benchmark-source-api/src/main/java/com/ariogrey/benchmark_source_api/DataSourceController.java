package com.ariogrey.benchmark_source_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
public class DataSourceController {

    private final FileService fileService;
    private final ExecutorService fixedThreadPool;
    private final ExecutorService virtualThreadExecutor;

    public DataSourceController(FileService fileService, ExecutorService fixedThreadPool, ExecutorService virtualThreadExecutor) {
        this.fileService = fileService;
        this.fixedThreadPool = fixedThreadPool;
        this.virtualThreadExecutor = virtualThreadExecutor;
    }

    // Traditional Thread Endpoint
    @GetMapping("/data-file-traditional")
    public String getFileDataTraditional() {
        try {
            Future<String> future = fixedThreadPool.submit(fileService::readFileContent);
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading file";
        }
    }

    // Reactive Endpoint
    @GetMapping("/data-file-reactive")
    public Mono<String> getFileDataReactive() {
        return Mono.fromCallable(fileService::readFileContent)
                .subscribeOn(Schedulers.boundedElastic());
    }

    // Virtual Thread Endpoint
    @GetMapping("/data-file-virtual")
    public String getFileDataVirtual() {
        try {
            Future<String> future = virtualThreadExecutor.submit(fileService::readFileContent);
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading file";
        }
    }

    @GetMapping("/data")
    public String getData() throws InterruptedException {
        Thread.sleep(500); // 500 ms delay to mimic slow database access
        return "Data from Database Simulation - 500ms delay";
    }

    @GetMapping("/data-cpu")
    public String getCpuIntensiveData() {
        // Simulate CPU-intensive work, e.g., finding prime numbers
        int result = calculatePrimes(10000);
        return "CPU Intensive Result: " + result;
    }

    private int calculatePrimes(int limit) {
        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}