package io.dddbyexamples.demo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

import static java.math.BigDecimal.TEN;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RepaymentsTest {

	private static final String ANY_CARD_NR = "nr";

	@Autowired
	TestRestTemplate testRestTemplate;

	@Autowired
	MessageCollector messageCollector;

	@Autowired
	Source source;

	BlockingQueue<Message<?>> outputEvents;

	@BeforeClass
	public void setup() {
		outputEvents = messageCollector.forChannel(source.output());
	}

	@Test
	public void should_show_correct_number_of_withdrawals_after_1st_withdrawal() {
		// given
		testRestTemplate.postForEntity("/withdrawals/" + ANY_CARD_NR, new WithdrawRequest(TEN), WithdrawRequest.class);

		// when
		testRestTemplate.postForEntity("/repayments/" + ANY_CARD_NR, new RepaymentRequest(TEN), RepaymentRequest.class);

		// then
		assertThat(outputEvents.poll().getPayload() instanceof MoneyRepaid).isTrue();
	}

}
