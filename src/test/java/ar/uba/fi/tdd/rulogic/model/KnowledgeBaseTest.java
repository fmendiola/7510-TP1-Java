package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class KnowledgeBaseTest {

	@InjectMocks
	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	public void test() {

		Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
	}
	
	@Test
	public void test_mujer_maria_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("mujer(maria) ."));
	}
	
	@Test
	public void test_juan_padre_pepe_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));
	}
	
	@Test
	public void test_invalid_query_isFalse() {
		Assert.assertFalse(this.knowledgeBase.answer("varo"));
	}
	
	@Test
	public void test_valid_fact_isFalse() {

		Assert.assertFalse(this.knowledgeBase.answer("mujer(pepe) ."));
	}
	
	@Test
	public void test_valid_rule_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe, juan)."));
	}
	
	@Test
	public void test_valid_rule_isFalse() {

		Assert.assertFalse(this.knowledgeBase.answer("hijo(maria, juan)."));
	}
	
	@Test
	public void test_valid_rule_tio_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, alejandro, roberto)."));
	}
	
	@Test
	public void test_valid_rule_tio_isFalse() {

		Assert.assertFalse(this.knowledgeBase.answer("tio(nicolas, mauro, roberto)."));
	}
}
