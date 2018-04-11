package io.dddbyexamples.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.math.BigDecimal.TEN;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WithdrawalsViewTest {

	private static final String ANY_CARD_NR = "nr";

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void should_show_correct_number_of_withdrawals_after_1st_withdrawal() {
		// when
		testRestTemplate.postForEntity("/withdrawals/" + ANY_CARD_NR, new WithdrawRequest(TEN), WithdrawRequest.class);

		// then
        ResponseEntity res = testRestTemplate.getForEntity("/withdrawals/" + ANY_CARD_NR, WithdrawRequest.class);
        assertThat(res.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(res.getBody()).hasSize(1);
	}

}
