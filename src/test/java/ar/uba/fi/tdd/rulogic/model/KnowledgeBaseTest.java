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

		Assert.assertTrue(this.knowledgeBase.answer("varon (javier)."));

	}
	
	@Test
	public void test_mujer_maria_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("mujer(maria) ."));

	}
	
	@Test
	public void test_juan_padre_pepe_isTrue() {

		Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));

	}

}
