package io.dddbyexamples.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MoneyRepaidListener {

    @StreamListener("cards")
    public void handle(MoneyRepaid moneyRepaid) {
        //..close statement
    }
}

class MoneyRepaid {

    final String cardNr;
    final BigDecimal amount;

    MoneyRepaid(String cardNr, BigDecimal amount) {
        this.cardNr = cardNr;
        this.amount = amount;
    }
}