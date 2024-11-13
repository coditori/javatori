package com.ariogrey.benchmark_source_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class BenchmarkSourceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchmarkSourceApiApplication.class, args);
	}

	@Bean
	public ExecutorService fixedThreadPool() {
		// Fixed thread pool to mimic traditional threading
		return Executors.newFixedThreadPool(10);
	}

	@Bean
	public ExecutorService virtualThreadExecutor() {
		// Virtual thread executor for lightweight concurrency
		return Executors.newVirtualThreadPerTaskExecutor();
	}
}
