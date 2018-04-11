package io.dddbyexamples.demo;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/repayments")
class RepaymentController {

    private final Source source;

    RepaymentController(Source source) {
        this.source = source;
    }

    @PostMapping("/{cardNr}")
    ResponseEntity repay(@PathVariable String cardNr, @RequestBody RepaymentRequest repaymentRequest) {
        //.. stack for commands
        // - call to CreditCard.repay(repaymentRequest.amount)
        // source.output().send(new GenericMessage<>(new MoneyRepaid(cardNr, repaymentRequest.amount)));
    }

}

class RepaymentRequest {

    final BigDecimal amount;

    RepaymentRequest(BigDecimal amount) {
        this.amount = amount;
    }
}

