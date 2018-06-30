package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class SomeDataServiceStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}



public class SomeBusinessStubTest {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		someBusiness.setSomeDataService(new SomeDataServiceStub());
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
	
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		int actualResult = someBusiness.calculateSum(new int[] {5});
		assertEquals(5, actualResult);
	}
	
	

}
