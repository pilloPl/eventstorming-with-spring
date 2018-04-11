package io.dddbyexamples.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StatementGeneratorTest {

	private static final String USED_CARD = "123";
	private static final String NOT_USED_CARD = "456";

	@Autowired StatementGenerator statementGenerator;
	@Autowired StatementRepository statementRepository;

	@Test
	public void should_create_statement_only_if_there_are_withdrawals() {
		// when
		statementGenerator.generateStatements();

		// then
		assertThat(statementRepository.findOpenByCardNr(USED_CARD)).hasSize(1);
		assertThat(statementRepository.findOpenByCardNr(NOT_USED_CARD)).hasSize(0);

	}

}
