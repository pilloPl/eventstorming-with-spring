package io.dddbyexamples.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoneyRepaidListenerTest {

	private static final String ANY_CARD_NR = "nr";

	@Autowired Sink sink;
	@Autowired StatementRepository statementRepository;

	@Test
	public void should_close_the_statement_when_money_repaid_event_happens() {
		// when
		sink.input().send(new GenericMessage<>(new MoneyRepaid(ANY_CARD_NR, TEN)));

		// then
		assertThat(statementRepository.findLastByCardNr(ANY_CARD_NR).isClosed()).isTrue();
	}

}
