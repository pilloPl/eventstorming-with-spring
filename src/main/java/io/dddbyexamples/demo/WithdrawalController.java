package io.dddbyexamples.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/withdrawals")
class WithdrawalController {

    @GetMapping("/{cardNr}")
    ResponseEntity withdrawalsForCard(@PathVariable String cardNr) {
        //.. stack for query
        // - direct call to DB to Withdrawals
    }

    @PostMapping("/{cardNr}")
    ResponseEntity withdraw(@PathVariable String cardNr, @RequestBody WithdrawRequest withdrawRequest) {
        //.. stack for commands
        // - call to CreditCard.withdraw(withdrawRequest.amount)
        // - insert new Withdrawal to DB if successfully withdrawn from card
    }

}

class WithdrawRequest {

    final BigDecimal amount;

    WithdrawRequest(BigDecimal amount) {
        this.amount = amount;
    }
}

