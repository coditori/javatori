package com.massoudafrashteh.code.spring.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * In-memory implementation of {@link TraceRepository}.
 *
 * @author Massoud Afrashteh
 */
@Component
public class InMemoryTraceRepository implements TraceRepository {

    private static final Logger HTTP_LOGGER = LoggerFactory.getLogger("http-logger");

    // For security matters it's better to not expose Traces on HTTP
    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> map) {
        Trace trace = new Trace(new Date(), map);
        String traceInfo = trace.getInfo().toString();
        HTTP_LOGGER.info(traceInfo);
    }
}