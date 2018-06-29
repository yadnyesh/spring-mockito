package io.yadnyesh.springmockito.business;

import static org.junit.Assert.*;
import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		int actualResult = someBusiness.calculateSum(new int[] {1,2,3,4,5});
		int expectedResult = 15;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_emptyArray() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		int actualResult = someBusiness.calculateSum(new int[] {});
		assertEquals(0, actualResult);
	}
	
	

}
