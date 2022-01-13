package springrest.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestapiApplicationTests {
	private Calculator c = new Calculator();
	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		// Expected
		int expectedResult = 17;
		//Actual
		int actualResult = c.doSum(12, 4, 1);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testProduct(){
		int expectedResult = 6;

		int actualResult = c.doProduct(2, 3);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

}
