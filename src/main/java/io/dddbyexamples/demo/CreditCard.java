package io.dddbyexamples.demo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
class CreditCard {

    //..fields will pop-up during TDD!

    void assignLimit(BigDecimal money) {
        if(limitAlreadyAssigned()) {
            // throw
        }
        //...
    }

    void withdraw(BigDecimal money) {
        if(limitNotAssigned()) {
            // throw
        }
        if(notEnoughMoney()) {
            // throw
        }
        if(withdrawalWithinLastHour()) {
            // throw
        }

        //...
    }

    void repay(BigDecimal money) {

    }

    boolean withdrawalWithinLastHour() {
        return false;
    }

    boolean notEnoughMoney() {
        return false;
    }

    boolean limitNotAssigned() {
        return false;
    }

    boolean limitAlreadyAssigned() {
        return false;
    }

}
