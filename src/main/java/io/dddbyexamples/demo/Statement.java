package io.dddbyexamples.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document
public class Statement {

    private String details;
    private BigDecimal amount;
    private Instant date;
    private boolean closed;

    ///..
}
