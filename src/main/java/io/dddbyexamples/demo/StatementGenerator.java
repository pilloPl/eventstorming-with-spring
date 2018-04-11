package io.dddbyexamples.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatementGenerator {

    @Scheduled
    public void generateStatements() {
        allCardNumbers()
                .forEach(this::generateIfNeeded);
    }

    private void generateIfNeeded(CardNr cardNr) {
        //query to card-operations
        //if 200 OK - generate and statement
    }

    private List<CardNr> allCardNumbers() {
         return null;
    }
}

