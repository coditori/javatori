package com.massoudafrashteh.code.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Massoud Afrashteh
 */
@Component
public class InMemoryTraceRepository implements HttpTraceRepository {
    private static final Logger HTTP_LOGGER = LoggerFactory.getLogger("http-logger");
    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

    @Override
    public List<HttpTrace> findAll() {
        return Collections.singletonList(lastTrace.get());
    }

    @Override
    public void add(HttpTrace trace) {
        if ("GET".equals(trace.getRequest().getMethod())) {
            lastTrace.set(trace);
            HTTP_LOGGER.info(trace.getRequest().getUri().toString());
            HTTP_LOGGER.info(trace.getRequest().getMethod());
            HTTP_LOGGER.info(trace.getRequest().getRemoteAddress());
        }
    }
}